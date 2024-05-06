package online.buza.blog.controller.ecommerce;


import lombok.extern.slf4j.Slf4j;
import online.buza.blog.annotation.AdminUserLogin;
import online.buza.blog.common.BaseResponse;
import online.buza.blog.common.ResponseCode;
import online.buza.blog.dto.ECStoreProductDto;
import online.buza.blog.entity.EcStoreProduct;
import online.buza.blog.service.ECProductService;
import online.buza.blog.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@Slf4j
@RestController
@RequestMapping("/api/ecommerce/product")
public class ProductController {

    @Autowired
    private ECProductService ecProductService;

    @AdminUserLogin
    @PostMapping(value = "/proc.do")
    public BaseResponse procECProduct(HttpServletRequest request, @RequestBody ECStoreProductDto ecStoreProductDto) {
        if (StringUtils.isEmpty(ecStoreProductDto.getProductName())) {
            return BaseResponse.valueOfFailureCodeMessage(ResponseCode.ILLEGAL_ARGUMENT.getCode(), ResponseCode.ILLEGAL_ARGUMENT.getDesc());
        }

        try {
            if (ecStoreProductDto.getId() == null || "".equals(ecStoreProductDto.getId().toString())) {
                // Insert New Product
                EcStoreProduct ecStoreProduct = new EcStoreProduct();
                ecStoreProduct.setProductName(ecStoreProductDto.getProductName());
                ecStoreProduct.setProductInfo(ecStoreProductDto.getProductInfo());

                boolean isSuccessInsert = ecProductService.insertECStoreProduct(ecStoreProduct);
                if (isSuccessInsert) {
                    return BaseResponse.valueOfSuccessMessage(ResponseCode.INSERT_SUCCESS.getDesc());
                }
                return BaseResponse.valueOfFailureMessage(ResponseCode.INSERT_ERROR.getDesc());
            } else {
                // Update New Product
                EcStoreProduct ecStoreProduct = new EcStoreProduct();
                ecStoreProduct.setId(ecStoreProductDto.getId());
                ecStoreProduct.setProductName(ecStoreProductDto.getProductName());
                ecStoreProduct.setProductInfo(ecStoreProductDto.getProductInfo());
                boolean isSuccessUpdate = ecProductService.updateECStoreProduct(ecStoreProduct);
                if (isSuccessUpdate) {
                    return BaseResponse.valueOfSuccessMessage(ResponseCode.SAVE_SUCCESS.getDesc());
                }
                return BaseResponse.valueOfFailureMessage(ResponseCode.SAVE_ERROR.getDesc());
            }
        } catch (Exception e) {
            e.printStackTrace();
            return BaseResponse.valueOfFailureMessage(ResponseCode.SAVE_ERROR.getDesc());
        }



    }


}
