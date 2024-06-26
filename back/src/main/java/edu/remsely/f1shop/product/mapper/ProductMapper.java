package edu.remsely.f1shop.product.mapper;

import edu.remsely.f1shop.order.dto.OrderProductDto;
import edu.remsely.f1shop.product.dto.ProductCreationDto;
import edu.remsely.f1shop.product.dto.ProductDto;
import edu.remsely.f1shop.product.dto.ProductUpdateDto;
import edu.remsely.f1shop.product.entity.CartEntity;
import edu.remsely.f1shop.product.entity.Product;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProductMapper {
    public Product toEntity(ProductCreationDto dto) {
        return Product.builder()
                .id(dto.getId())
                .category(dto.getCategory())
                .name(dto.getName())
                .description(dto.getDescription())
                .image(dto.getImage())
                .price(dto.getPrice())
                .amount(dto.getAmount())
                .build();
    }

    public Product toEntity(ProductUpdateDto dto) {
        return Product.builder()
                .category(dto.getCategory())
                .name(dto.getName())
                .description(dto.getDescription())
                .image(dto.getImage())
                .price(dto.getPrice())
                .amount(dto.getAmount())
                .build();
    }

    public ProductDto toDto(Product product, boolean inWishlist, boolean inCart) {
        return ProductDto.builder()
                .id(product.getId())
                .category(product.getCategory())
                .name(product.getName())
                .description(product.getDescription())
                .image(product.getImage())
                .inWishlist(inWishlist)
                .inCart(inCart)
                .price(product.getPrice())
                .build();
    }

    public OrderProductDto toDto(CartEntity cartEntity) {
        return OrderProductDto.builder()
                .id(cartEntity.getProduct().getId())
                .name(cartEntity.getProduct().getName())
                .image(cartEntity.getProduct().getImage())
                .price(cartEntity.getProduct().getPrice())
                .amount(cartEntity.getAmount())
                .build();
    }

    public ProductCreationDto toDto(Product product) {
        return ProductCreationDto.builder()
                .id(product.getId())
                .category(product.getCategory())
                .name(product.getName())
                .description(product.getDescription())
                .image(product.getImage())
                .price(product.getPrice())
                .amount(product.getAmount())
                .build();
    }

    public List<OrderProductDto> toDtoList(List<CartEntity> cartEntityList) {
        return cartEntityList.stream()
                .map(this::toDto)
                .toList();
    }
}
