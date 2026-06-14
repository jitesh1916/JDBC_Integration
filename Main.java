package com.JDBC_Integration;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        ProductDAO productDAO = new ProductDAO();
        Scanner input = new Scanner(System.in);
        boolean loop = true;

        while(loop==true){

            System.out.println();
            System.out.println("=============================================");
            System.out.println("Welcome To Product Inventry Management System");
            System.out.println("=============================================");

            System.out.println("1. Create Product Table");
            System.out.println("2. Insert Products");
            System.out.println("3. View All Products");
            System.out.println("4. update Product");
            System.out.println("5. Delete Product");
            System.out.println("6. Exit Program");
            System.out.println();


            System.out.println("Enter Your Choice : ");
            int choice = input.nextInt();
            input.nextLine();

            switch (choice){
                case 1:
                    productDAO.createTable();
                    break;

                case 2:
                    System.out.println("Enter Product Name : ");
                    String name = input.nextLine();
                    System.out.println("Enter Product Price : ");
                    double price = input.nextDouble();
                    System.out.println("Enter Product Quantity : ");
                    int quantity = input.nextInt();
                    input.nextLine();
                    System.out.println("Enter Product Category : ");
                    String category = input.nextLine();

                    Product product= new Product(name,category,price,quantity);
                    productDAO.insertProduct(product);
                    System.out.println("Product Inserted Successfully");
                    break;

                case 3:
                    productDAO.getAllProducts();
                    break;

                case 4:
                    System.out.println("Enter Product ID : ");
                    int searchId = input.nextInt();
                    Product searchProduct = productDAO.searchProductById(searchId);

                    if(searchProduct != null){

                        System.out.println("Product Id : "+ searchProduct.getProductId());
                        System.out.println("Product Name : "+ searchProduct.getProductName());
                        System.out.println("Product Price : " +searchProduct.getPrice() );
                        System.out.println("Product Quantity : " +searchProduct.getQuantity() );
                        System.out.println("Product Category : " +searchProduct.getCategory() );

                        System.out.println("What You want to update : ");
                        System.out.println("1.Product Price");
                        System.out.println("2.Product Quantity");
                        System.out.println("Enter Your Choice : ");
                        int update = input.nextInt();

                        switch(update){
                            case 1:
                                System.out.println("Enter new Product Price : ");
                                double newPrice = input.nextDouble();
                                boolean res = productDAO.updateProductPrice(newPrice,searchId);
                                if(res)
                                    System.out.println("Product Updated Successfully");
                                else
                                    System.out.println("Product Updated Failed");

                                break;

                            case 2:
                                System.out.println("Enter new Product Quantity : ");
                                int newQuantity = input.nextInt();
                                boolean res1 =  productDAO.updateProductQuantity(newQuantity,searchId);
                                if(res1)
                                    System.out.println("Product Updated Successfully");
                                else
                                    System.out.println("Product Updated Failed");
                        }

                    }
                    else
                        System.out.println("Product Not Found");

                    break;

                case 5:
                    System.out.println("Enter Product ID : ");
                    int productId = input.nextInt();

                    boolean res = productDAO.deleteProduct(productId);

                    if(res)
                        System.out.println("Product Deleted Successfully");
                    else
                        System.out.println("Product Not Found");
                    break;

                case 6:
                    loop=false;
                    System.out.println("Thank You");
                    break;

                default:
                    System.out.println("Invalid choice");

            }
        }

    }
}
