# TIL (Today I Learned)



## Product Entity

```java
package com.kurlabo.backend.model;

import com.kurlabo.backend.converter.JsonConverter;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@Builder
@RequiredArgsConstructor
@AllArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private Long id;
  
    private int category;
  
    @Convert(converter = JsonConverter.class)
    @Column(columnDefinition = "text")
    private String data;
}
```

- 상품 정보를 담기 위한 entity
- `private String data;` 는 json 형식으로 product 테이블의 data 컬럼에 저장되어 있다.
  - 상품에 대한 정보들

<br>

## Product Detail Entity

```java
package com.kurlabo.backend.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@Builder
@RequiredArgsConstructor
@AllArgsConstructor
public class ProductDetail {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "product_detail_id")
  private Long id;
  
  private String detail_img_url; // 상품설명 대표 이미지
  
  private String detail_context; // 상품설명 내용
  
  private String detail_title; // 상품설명 제목
  
  private String product_img_url; // 상품이미지 태그 이미지 url

}
```

- 상품 상세 이미지 및 설명 정보 entity
- Product entity는 상품명, 가격, 판매수량, 세일 여부 등의 정보를 가졌고
- ProductDetail은 상품 상세보기 페이지에서 확인 할 수 있는 이미지와 상품에 대한 설명을 가지고 있다.

<br>

## GoodsService

```java
package com.kurlabo.backend.service;

import com.kurlabo.backend.dto.goods.GoodsListResponseDto;
import com.kurlabo.backend.dto.review.ReviewDto;
import com.kurlabo.backend.exception.ResourceNotFoundException;
import com.kurlabo.backend.model.Product;
import com.kurlabo.backend.model.Review;
import com.kurlabo.backend.repository.ProductRepository;
import com.kurlabo.backend.dto.goods.ProductDto;
import com.kurlabo.backend.dto.goods.RelatedProductDto;
import com.kurlabo.backend.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

@Service
@RequiredArgsConstructor
public class GoodsService {

    private final ProductRepository productRepository;
    private final ReviewRepository reviewRepository;

    public ProductDto goodDetail(Pageable pageable, Long id) { // 상품 상세 정보 출력 
      Product product = productRepository.findById(id)
                .orElseThrow(ResourceNotFoundException::new); // 상품이 없음 

      Page<Review> reviews = reviewRepository.findAllByProduct(product, pageable); // 상품에 달린 리뷰를 가져옴 

      List<ReviewDto> reviewList = new ArrayList<>();
      for(Review review: reviews){
        ReviewDto list = new ReviewDto(
          review.getReview_id(),
          review.getMember().getId(),
          review.getProduct().getId(),
          review.getTitle(),
          review.getContent(),
          review.getMember().getName(),
          review.getRegdate(),
          review.getHelp(),
          review.getCnt()
        );
        reviewList.add(list);
      } // end for 

        List<Product> related_product = new ArrayList<>(); // 상위 카테고리에서 아이템 랜덤으로 넣을 리스트
        List<RelatedProductDto> list = new ArrayList<>();
        List<Integer> intList = new ArrayList<>();
        Random random = new Random();

        switch (product.getCategory()/10) {
            case 0:
                related_product = productRepository.findByCategoryVege();
                break;
            case 1:
                related_product = productRepository.findByCategoryFruits();
                break;
            case 2:
                related_product = productRepository.findByCategorySeafood();
                break;
            case 3:
                related_product = productRepository.findByCategoryMeat();
                break;
            case 4:
                related_product = productRepository.findByCategoryMaindish();
                break;
            case 5:
                related_product = productRepository.findByCategoryFastFood();
                break;
            case 6:
                related_product = productRepository.findByCategoryNoodleoil();
                break;
            case 7:
                related_product = productRepository.findByCategoryDring();
                break;
            case 8:
                related_product = productRepository.findByCategorySnacks();
                break;
            case 9:
                related_product = productRepository.findByCategoryBakery();
                break;
            case 10:
                related_product = productRepository.findByCategoryHealthFood();
                break;
            case 11:
                related_product = productRepository.findByCategoryLiving();
                break;
            case 12:
                related_product = productRepository.findByCategoryBeauty();
                break;
            case 13:
                related_product = productRepository.findByCategoryKitchen();
                break;
            case 14:
                related_product = productRepository.findByCategoryHomeAppliance();
                break;
            case 15:
                related_product = productRepository.findByCategoryBabyKiz();
                break;
            case 16:
                related_product = productRepository.findByCategoryPet();
                break;
        }

      int max = related_product.size() - 1;
      
      if (max > 20){
        max = 20;
      }

      for (int i = 0; i < max; i++) {
        int n = random.nextInt(related_product.size());
        while (intList.contains(n)){ // 중복 랜덤상품 제거 
          n = random.nextInt(related_product.size());
        }
        intList.add(n);
        
        Product getRelate = related_product.get(n);
        
        if(getRelate.getId().equals(id)){
          i--;
          continue;
        }

        list.add(new RelatedProductDto(
          getRelate.getId(),
          getRelate.getName(),
          getRelate.getOriginal_image_url(),
          getRelate.getOriginal_price(),
          getRelate.getDiscounted_price()
        ));
      }

        String getGuides = product.getGuides().replace('|','"');
        getGuides = getGuides.replace('\'',' ')
                .replace("[", "")
                .replace("]", "");

        String[] array = getGuides.split(",");
        List<String> getGuide = new ArrayList<>();

        for(int i = 0; i < array.length; i++) {
            getGuide.add(array[i]);
        }

        ProductDto productDto = new ProductDto();
        productDto.setProduct_id(product.getId());
        productDto.setName(product.getName());
        productDto.setShort_description(product.getShort_description());
        productDto.setUnit_text(product.getUnit_text());
        productDto.setWeight(product.getWeight());
        productDto.setOrigin(product.getOrigin());
        productDto.setContactant(product.getContactant());
        productDto.setBrand_title(product.getBrand_title());
        productDto.setExpiration_date(product.getExpiration_date());
        productDto.setDelivery_time_type_text(product.getDelivery_time_type_text());
        productDto.setOriginal_price(product.getOriginal_price());
        productDto.setDiscounted_price(product.getDiscounted_price());
        productDto.setDiscount_percent(product.getDiscount_percent());
        productDto.setDiscount_end_datetime(product.getDiscount_end_datetime());
        productDto.setOriginal_image_url(product.getOriginal_image_url());
        productDto.setMain_image_url(product.getMain_image_url());
        productDto.setList_image_url(product.getList_image_url());
        // productDto.setDetail_image_url(product.getDetail_image_url());
        productDto.setSticker_image_url(product.getSticker_image_url());
        productDto.setDetail_img_url(product.getDetail_img_url());
        productDto.setDetail_title(product.getDetail_title());
        productDto.setDetail_context(product.getDetail_context());
        productDto.setProduct_img_url(product.getProduct_img_url());
        productDto.setGuides(getGuide);
        productDto.setPacking_type_text(product.getPacking_type_text());

        productDto.setReviews(reviewList);
        productDto.setRelated_product(list);

        return productDto;
    }
}
```

<br>

## GoodsController

```java
package com.kurlabo.backend.controller;

import com.kurlabo.backend.dto.cart.*;
import com.kurlabo.backend.dto.goods.ProductDto;
import com.kurlabo.backend.model.Member;
import com.kurlabo.backend.model.Review;
import com.kurlabo.backend.service.CartService;
import com.kurlabo.backend.service.GoodsService;
import com.kurlabo.backend.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@CrossOrigin(origins = "*")
@RestController
@RequiredArgsConstructor
@RequestMapping(value="/api/goods")
public class GoodsController {

    private final MemberService memberService;
    private final CartService cartService;
    private final GoodsService goodsService;

    @GetMapping("/{id}")
    public ResponseEntity<ProductDto> goodDetail(@PageableDefault(size = 7) Pageable pageable,
                                                 @PathVariable(name = "id") Long id) {

        return ResponseEntity.ok(goodsService.goodDetail(pageable, id));
    }
}
```

- 한 상품 페이지에서 7개의 리뷰만 보여주기 위해 사이즈를 7로 지정

- cross-domain 이슈 : 보안상의 이유로 자신과 동일한 도메인으로만 HTTP요청을 보내도록 제한하고 있어 에러 발생

  - CORS(Cross-origin resource sharing)이란, 웹 페이지의 제한된 자원을 외부 도메인에서 접근을 허용해주는 메커니즘
  - @CrossOrigin 어노테이션을 사용하여 해결 
  - RestController를 사용한 클래스 자체에 적용할 수도 있고, 특정 REST API method에도 설정 가능

  ```JAVA
  //해당 컨트롤러의 모든 요청에 대한 접근 허용
  @CrossOrigin(origins = "*")
  @RestController
  public class CorssampleApplication {
    ...
  }
  
  //해당 컨트롤러의 모든 요청에 대한 접근 허용 -> 아래 도메인 두개에 대해서만
  // 만약 이 코드가 실행되는 웹서버의 도메인이 http://localhost:8080 http://localhost:80801 아닐경우 fail이 발생한다.
  @CrossOrigin(origins = {"http://localhost:8080", "http://localhost:8081" }) 
  @RestController
  public class CorssampleApplication {
    ...
  }
  ```

  