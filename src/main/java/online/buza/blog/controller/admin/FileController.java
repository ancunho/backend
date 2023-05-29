package online.buza.blog.controller.admin;

import com.github.pagehelper.PageHelper;
import lombok.extern.slf4j.Slf4j;
import online.buza.blog.annotation.AdminUserLogin;
import online.buza.blog.annotation.PassLogin;
import online.buza.blog.common.BaseRequest;
import online.buza.blog.common.BaseResponse;
import online.buza.blog.common.Const;
import online.buza.blog.common.ResponseCode;
import online.buza.blog.dto.SysUserDto;
import online.buza.blog.dto.TbFileListDto;
import online.buza.blog.entity.TbFileList;
import online.buza.blog.service.AliyunService;
import online.buza.blog.service.FileService;
import online.buza.blog.service.S3Service;
import online.buza.blog.util.Box;
import online.buza.blog.util.FileUtil;
import online.buza.blog.util.HttpUtility;
import online.buza.blog.util.PropertiesUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping(value = "/api/file/handle")
public class FileController {

    @Autowired
    private AliyunService aliyunService;

    @Autowired
    private S3Service s3Service;

    @Autowired
    private FileService fileService;

    @AdminUserLogin
    @PostMapping(value = "/upload.do")
    public Map<String, Object> file_upload_return_url(HttpServletRequest request, @RequestParam(value = "file", required = false) MultipartFile file) throws Exception {
        Map<String, Object> result = new HashMap<>();
        List<String> imgList = new ArrayList<>();
//        for (MultipartFile file : multipartFiles) {
        //Const.UPLOAD_IMAGE_MAX_SIZE : 2MB
        if (file.getSize() > 0 && file.getSize() <= (Const.UPLOAD_IMAGE_MAX_SIZE * 20)) {
            String file_path_url = aliyunService.uploadFileReturnURL(file);
            imgList.add(file_path_url);
            result.put("errno", 0);
            result.put("data", imgList);

        } else {
            result.put("errno", 99);
            result.put("data", imgList);
        }
//        }
        return result;
    }

    @PassLogin
    @PostMapping(value = "/wangEditor/single/upload.do")
    public Map<String, Object> file_wangEditor_upload_return_url(HttpServletRequest request, @RequestParam(value = "editorImageFile", required = false) MultipartFile file) throws Exception {
        Map<String, Object> result = new HashMap<>();
//        for (MultipartFile file : multipartFiles) {
        //Const.UPLOAD_IMAGE_MAX_SIZE : 2MB

        if (file.getSize() > 0 && file.getSize() <= (Const.UPLOAD_IMAGE_MAX_SIZE * 100)) {
//            File fileOrg = FileUtil.convertMultipartFileToFile(file);
//            String file_path_url = s3Service.updateFileToS3ReturnETag(file);
            String file_path_url = aliyunService.uploadFileReturnURL(file);
            Map<String, String> returnData = new HashMap<>();
            if ("".equals(file_path_url)) {
                result.put("errno", 1);
                result.put("message", "上传失败");
            } else {
                returnData.put("url", file_path_url);
                result.put("errno", 0);
                result.put("data", returnData);
            }
        } else {
            result.put("errno", 1);
            result.put("message", "上传失败");
        }
//        }
        return result;
    }

    @AdminUserLogin
    @PostMapping(value = "/single/image/upload.do")
    public Map<String, Object> image_upload_return_url(HttpServletRequest request, @RequestBody TbFileListDto tbFileListDto, @RequestParam(value = "file", required = false) MultipartFile file) throws Exception {
        Map<String, Object> result = new HashMap<>();
        //Const.UPLOAD_IMAGE_MAX_SIZE : 2MB
        Map<String, Object> imageMap = new HashMap<>();
        if (file.getSize() > 0 && file.getSize() <= (Const.UPLOAD_IMAGE_MAX_SIZE * 20)) {
            imageMap = aliyunService.uploadImageReturnURL(file);
            result.put("errno", 0);
            result.put("data", imageMap);
        } else {
            result.put("errno", 99);
            result.put("data", imageMap);
        }
        return result;
    }

    @AdminUserLogin
    @PostMapping(value = "/multie/image/upload.do")
    public BaseResponse image_multie_upload_return_url(HttpServletRequest request, @RequestParam("imageFiles") List<MultipartFile> multipartFileList) {
        Box box = HttpUtility.getBox(request);
        HttpSession session = request.getSession();
        SysUserDto loginUser = (SysUserDto) session.getAttribute("LOGINED_USER");
        try {
            if (multipartFileList.size() > 0) {
                Map<String, Object> returnFileMap;
                boolean resultFlag = false;
                String resultMessage = "Fail";
                for (MultipartFile file : multipartFileList) {
                    // 1. aliyun oss save
                    returnFileMap = aliyunService.uploadImageReturnURL(file);

                    boolean isOSSSuccess = (boolean) returnFileMap.get("success");
                    if (isOSSSuccess) {
                        // 2. file info save in DB
                        TbFileList tbFileList = new TbFileList();
                        tbFileList.setFileType(box.get("fileType")); // image,audio,video,file
                        tbFileList.setFileOriginName(returnFileMap.get("imageOriginName").toString());
                        tbFileList.setFileName(returnFileMap.get("imageName").toString());
                        tbFileList.setFilePath(returnFileMap.get("imagePath").toString());
                        tbFileList.setFileBucketName(PropertiesUtils.getAliyunOssFileBucketName());
                        tbFileList.setFileBucketObject(returnFileMap.get("imageObject").toString());
                        tbFileList.setFileSize(String.valueOf(file.getSize()));
                        tbFileList.setFileExtention(returnFileMap.get("imageExt").toString());
                        tbFileList.setFileUrl(returnFileMap.get("imageUrl").toString());
                        tbFileList.setFileSort(null);
                        tbFileList.setFileIsMain(null);
                        tbFileList.setFileRemark(null);
                        tbFileList.setStatus("1");
                        tbFileList.setOption01(loginUser.getUsername());
                        tbFileList.setOption02(null);
                        tbFileList.setOption03(null);
                        tbFileList.setOption04(null);
                        tbFileList.setOption05(null);

                        boolean isSuccessInsert = fileService.insertTbFileList(tbFileList);
                        if (isSuccessInsert) {
                            resultFlag = true;
                            resultMessage = ResponseCode.INSERT_SUCCESS.getDesc();
                        } else {
                            resultMessage = ResponseCode.INSERT_ERROR.getDesc();
                        }
                    } else {
                        resultMessage = "上传到阿里云服务器失败， 请重试或联系管理员";
                    }
                }

                if (resultFlag) {
                    return BaseResponse.valueOfSuccessMessage(resultMessage);
                }
                return BaseResponse.valueOfFailureMessage(resultMessage);
            } else {
                return BaseResponse.valueOfFailureMessage("系统未发现上传图片， 请确认");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return BaseResponse.valueOfFailureMessage(ResponseCode.SAVE_ERROR.getDesc());
        }

    }

    @AdminUserLogin
    @PostMapping(value = "/single/image/delete.do")
    public BaseResponse image_delete(HttpServletRequest request, @RequestParam("imageUrl") String imageUrl) throws Exception {
        if (imageUrl == null || "".equals(imageUrl)) {
            return BaseResponse.valueOfFailureCodeMessage(ResponseCode.ILLEGAL_ARGUMENT.getCode(), ResponseCode.ILLEGAL_ARGUMENT.getDesc());
        }

        Map<String, Object> mapParams = new HashMap<>();
        mapParams.put("imageUrl", imageUrl);
        aliyunService.deleteImage(mapParams);
        return BaseResponse.valueOfSuccessMessage("删除成功");
    }

    @AdminUserLogin
    @PostMapping(value = "/list.do")
    public BaseResponse getAllTbFileList(BaseRequest baseRequest, @RequestBody TbFileListDto tbFileListDto) {
        PageHelper.startPage(baseRequest.getPage(), baseRequest.getLimit());
        List<TbFileListDto> returnData = fileService.getAllTbFileList(tbFileListDto);
        return BaseResponse.valueOfSuccessList(returnData);
    }

    @AdminUserLogin
    @GetMapping(value = "/info.do")
    public BaseResponse getTbFileListInfoByFileId(BaseRequest baseRequest, @RequestParam("fileId") Integer fileId) {
        if (fileId == null) {
            return BaseResponse.valueOfFailureCodeMessage(ResponseCode.ILLEGAL_ARGUMENT.getCode(), ResponseCode.ILLEGAL_ARGUMENT.getDesc());
        }

        TbFileListDto tbFileListDto = fileService.getTbFileListInfoByFileId(fileId);
        return BaseResponse.valueOfSuccess(tbFileListDto);
    }


}
