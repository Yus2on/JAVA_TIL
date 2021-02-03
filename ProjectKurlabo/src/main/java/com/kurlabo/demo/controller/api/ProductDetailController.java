package com.kurlabo.demo.controller.api;

import com.kurlabo.demo.dto.ProductDto;
import com.kurlabo.demo.model.Header;
import com.kurlabo.demo.model.Product;
import com.kurlabo.demo.service.ProductDetailApiService;
import org.springframework.http.ResponseEntity;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/shop")
public class ProductDetailController {

    @Autowired
    private final ProductDetailApiService productDetailApiService;

    @GetMapping("/header")
    public Header getHeader(){
        return Header.builder().resultCode("OK").description("OKKKKKK").build();
    }

    @GetMapping("/product/{id}")
    public ResponseEntity<ProductDto> getProduct(@PathVariable(name = "id") Long id) {
        log.info("getProduct id : {}" , id);
        Product product = productDetailApiService.getProduct(id);

        return ResponseEntity.ok(response(product));
    }

    private ProductDto response (Product product) {
        return ProductDto.builder()
                .productId(product.getProductId())
                .name(product.getName())
                .shortDescription(product.getShortDescription())
                .category(product.getCategory())
                .brandTitle(product.getBrandTitle())
                .originalPrice(product.getOriginalPrice())
                .discountedPrice(product.getDiscountedPrice())
                .discountPercent(product.getDiscountPercent())
                .unitText(product.getUnitText())
                .weight(product.getWeight())
                .deliveryTypeText(product.getDeliveryTypeText())
                .packingTypeText(product.getPackingTypeText())
                .minEa(product.getMinEa())
                .maxEa(product.getMaxEa())
                .detailImageUrl(product.getDetailImageUrl())
                .mainImageUrl(product.getMainImageUrl())
                .originalImageUrl(product.getOriginalImageUrl())
                .origin(product.getOrigin())
                .reviewCount(product.getReviewCount())
                .productDetail(product.getProductDetail())
                .build();
    }


//
//
//    @RequestMapping(value = "/main", method = RequestMethod.GET)
//    public List<ProductDetail> getAllMainProducts() {
//        List<ProductDetail> productsList = productRepository.findAll();
//
//        return productsList;
//    }
//
//    @RequestMapping(value = "/shop/products/{productId}", method = RequestMethod.GET)
//    @ResponseBody
//    public ProductDetail getByProduct(@PathVariable("productId") Long productId) {
//        // Products product = productRepository.findById(productId).orElse(Products.emptyObject());
//        // return product;
//        return productService.getAllProduct(productId);
//    }

}
