package online.buza.blog.controller.admin;

import com.github.pagehelper.PageHelper;
import lombok.extern.slf4j.Slf4j;
import online.buza.blog.annotation.AdminUserLogin;
import online.buza.blog.common.BaseRequest;
import online.buza.blog.common.BaseResponse;
import online.buza.blog.common.ResponseCode;
import online.buza.blog.dto.LabelDto;
import online.buza.blog.dto.TbCommonCodeDto;
import online.buza.blog.entity.TbCommonCode;
import online.buza.blog.service.CommonCodeService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Slf4j
@RestController
@RequestMapping(value = "/api/common_code")
public class CommonCodeController {

    @Autowired
    private CommonCodeService commonCodeService;

    @AdminUserLogin
    @PostMapping(value = "/proc.do")
    public BaseResponse modifyTbCommonCode(HttpServletRequest request, @RequestBody TbCommonCodeDto tbCommonCodeDto) {
        if (StringUtils.isEmpty(tbCommonCodeDto.getCodeName())
                || StringUtils.isEmpty(tbCommonCodeDto.getCodeCd())
        ) {
            return BaseResponse.valueOfFailureCodeMessage(ResponseCode.ILLEGAL_ARGUMENT.getCode(), ResponseCode.ILLEGAL_ARGUMENT.getDesc());
        }

        try {
            if (tbCommonCodeDto.getCodeId() == null || String.valueOf(tbCommonCodeDto.getCodeId()) == "") {
                // insert New
                TbCommonCode tbCommonCode = new TbCommonCode();
                tbCommonCode.setCodeType(tbCommonCodeDto.getCodeType());
                tbCommonCode.setCodeCd(tbCommonCodeDto.getCodeCd());
                tbCommonCode.setCodeName(tbCommonCodeDto.getCodeName());
                tbCommonCode.setUseYn(tbCommonCodeDto.getUseYn());
                tbCommonCode.setSort(tbCommonCodeDto.getSort());
                tbCommonCode.setRemark(tbCommonCodeDto.getRemark());
                tbCommonCode.setOption01(tbCommonCodeDto.getOption01());
                tbCommonCode.setOption02(tbCommonCodeDto.getOption02());
                tbCommonCode.setOption03(tbCommonCodeDto.getOption03());
                tbCommonCode.setOption04(tbCommonCodeDto.getOption04());
                tbCommonCode.setOption05(tbCommonCodeDto.getOption05());

                boolean isSuccessInsert = commonCodeService.insertTbCommonCode(tbCommonCode);

                if (isSuccessInsert) {
                    return BaseResponse.valueOfSuccessMessage(ResponseCode.INSERT_SUCCESS.getDesc());
                }
                return BaseResponse.valueOfFailureMessage(ResponseCode.INSERT_ERROR.getDesc());
            } else {
                // update
                TbCommonCode tbCommonCode = new TbCommonCode();
                tbCommonCode.setCodeId(tbCommonCodeDto.getCodeId());
                tbCommonCode.setCodeType(tbCommonCodeDto.getCodeType());
                tbCommonCode.setCodeCd(tbCommonCodeDto.getCodeCd());
                tbCommonCode.setCodeName(tbCommonCodeDto.getCodeName());
                tbCommonCode.setUseYn(tbCommonCodeDto.getUseYn());
                tbCommonCode.setSort(tbCommonCodeDto.getSort());
                tbCommonCode.setRemark(tbCommonCodeDto.getRemark());
                tbCommonCode.setOption01(tbCommonCodeDto.getOption01());
                tbCommonCode.setOption02(tbCommonCodeDto.getOption02());
                tbCommonCode.setOption03(tbCommonCodeDto.getOption03());
                tbCommonCode.setOption04(tbCommonCodeDto.getOption04());
                tbCommonCode.setOption05(tbCommonCodeDto.getOption05());

                boolean isSuccessUpdate = commonCodeService.updateTbCommonCode(tbCommonCode);

                if (isSuccessUpdate) {
                    return BaseResponse.valueOfSuccessMessage(ResponseCode.SAVE_SUCCESS.getDesc());
                }
                return BaseResponse.valueOfFailureMessage(ResponseCode.SAVE_ERROR.getDesc());
            }
        } catch (Exception e) {
            e.printStackTrace();
            return BaseResponse.valueOfFailureMessage(ResponseCode.ERROR.getDesc());
        }
    }

    @AdminUserLogin
    @PostMapping(value = "/list.do")
    public BaseResponse getAllTbCommonCodeList(BaseRequest baseRequest, @RequestBody TbCommonCodeDto tbCommonCodeDto) {
        PageHelper.startPage(baseRequest.getPage(), baseRequest.getLimit());
        List<TbCommonCodeDto> returnData = commonCodeService.getAllTbCommonCodeList(tbCommonCodeDto);
        return BaseResponse.valueOfSuccessList(returnData);
    }

    @AdminUserLogin
    @GetMapping(value = "/info.do")
    public BaseResponse getTbCommonCodeInfoByCodeId(@RequestParam("codeId") Integer codeId) {
        if (codeId == null) {
            return BaseResponse.valueOfFailureCodeMessage(ResponseCode.ILLEGAL_ARGUMENT.getCode(), ResponseCode.ILLEGAL_ARGUMENT.getDesc());
        }

        TbCommonCodeDto tbCommonCodeDto = commonCodeService.getTbCommonCodeInfoByCodeId(codeId);
        return BaseResponse.valueOfSuccess(tbCommonCodeDto);
    }

    @AdminUserLogin
    @PostMapping(value = "/delete.do")
    public BaseResponse code_delete(BaseRequest baseRequest, @RequestBody TbCommonCodeDto tbCommonCodeDto) {
        if (tbCommonCodeDto == null || "".equals(String.valueOf(tbCommonCodeDto.getCodeId()))) {
            return BaseResponse.valueOfFailureMessage(ResponseCode.ILLEGAL_ARGUMENT.getDesc());
        }

        boolean isSuccessDelete = commonCodeService.deleteTbCommonCode(tbCommonCodeDto);
        if (isSuccessDelete) {
            return BaseResponse.valueOfSuccessMessage(ResponseCode.DELETE_SUCCESS.getDesc());
        }
        return BaseResponse.valueOfFailureMessage(ResponseCode.DELETE_ERROR.getDesc());
    }


    @AdminUserLogin
    @GetMapping(value = "/type/list.do")
    public BaseResponse lstTbCommonCodeByCodeType(@RequestParam("codeType") String codeType) {
        if (codeType == null || StringUtils.isEmpty(codeType)) {
            return BaseResponse.valueOfFailureCodeMessage(ResponseCode.ILLEGAL_ARGUMENT.getCode(), ResponseCode.ILLEGAL_ARGUMENT.getDesc());
        }

        List<TbCommonCodeDto> lstTbCommonCodeByCodeType = commonCodeService.lstTbCommonCodeByCodeType(codeType);
        return BaseResponse.valueOfSuccess(lstTbCommonCodeByCodeType);
    }

    @AdminUserLogin
    @PostMapping(value = "/group_type.do")
    public BaseResponse getAllGroupTypeCommonCode(BaseRequest baseRequest, @RequestBody TbCommonCodeDto tbCommonCodeDto) {
        List<TbCommonCodeDto> commonCodeDtoList = commonCodeService.getAllGroupTypeCommonCode(tbCommonCodeDto);
        return BaseResponse.valueOfSuccessList(commonCodeDtoList);
    }

}
