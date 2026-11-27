package com.mftplus;

import com.mftplus.da.ProductDataAccess;
import com.mftplus.model.Product;

public class Main {
    public static void main(String[] args) {
        ProductDataAccess productDa = new ProductDataAccess();

        // ذخیره یک محصول در دیتابیس
        Product product = Product.builder()
                .id(1L)
                .name("Laptop")
                .brand("Lenovo")
                .price(1200.50)
                .build();
        productDa.save(product);

        // ویرایش قیمت همان محصول
        product.setPrice(1400.00);
        productDa.update(product);
    }
}