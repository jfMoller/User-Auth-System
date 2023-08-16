<template>
    <div class="container">
      <ul class="product-list">
        <li class="product" v-for="product in products" :key="product.id">
          <div class="product-details">
            <h2 class="product-title">{{ product.name }}</h2>
            <p class="product-price">{{ product.id }}</p>
          </div>
        </li>
      </ul>
    </div>
  </template>
  
  <script>
  import { API } from '../network/API';
  
  export default {
    data() {
      return {
        products: []
      };
    },
  
    async created() {
      await this.getAllProducts();
    },
  
    methods: {
      async getAllProducts() {
        try {
          const products = await API.getAllProducts();
          this.products = products;
        } catch (error) {
          console.error('Error fetching products:', error);
        }
      }
    }
  };
  </script>
  
  <style scoped>
  .container {
    max-width: 1200px;
    margin: 0 auto;
    padding: 20px;
  }
  
  .product-list {
    list-style: none;
    padding: 0;
  }
  
  .product {
    background-color: #fff;
    border-radius: 8px;
    padding: 20px;
    margin-bottom: 20px;
  }
  
  .product-details {
    display: flex;
    flex-direction: column;
  }
  
  .product-title {
    font-size: 1.2rem;
    font-weight: bold;
    margin: 0;
  }
  
  .product-price {
    font-size: 1.1rem;
    color: #e74c3c;
  }
  
  .product-description {
    margin-top: 10px;
    color: #555;
  }
  </style>