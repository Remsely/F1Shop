import React from 'react';
import {useParams} from "react-router-dom";
import ProductService from "../API/ProductService";
import ContentDiv from "../components/UI/contentDiv/ContentDiv";
import ProductInfo from "../components/productInfo/ProductInfo";

const ProductPage = () => {
    const params = useParams()
    const product = ProductService.getProductByID(params.id);

    return (
        <ContentDiv>
            <h2>{product.name}</h2>
            <ProductInfo product={product}/>
        </ContentDiv>
    );
};

export default ProductPage;