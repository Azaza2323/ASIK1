# Online Shopping Cart with Strategy Pattern

This Java application demonstrates an online shopping cart system using the Strategy Pattern. It includes classes for products, a shopping cart, and a checkout process with payment and discount strategies.

## Requirements

1. **Product class with attributes such as name, price, and quantity:**
    - Implemented in the `Product` class.

2. **ShoppingCart class that allows adding products, calculating the total price, and checking out:**
    - Implemented in the `Shopping` class.

3. **PaymentStrategy interface with a method `processPayment(double amount)`:**
    - Defined in the `PaymentStrategy` interface.

4. **Two concrete payment strategies:**
    - Implemented as `KaspiCard` and `Jusan` classes.

5. **Modify the PaymentProcessor class to accept a payment strategy and use it to process payments:**
    - Implemented `PaymentProcessor` class and integrated it into the `Shopping` class.

6. **Modify the shopping cart's checkout process to use the selected payment strategy:**
    - The checkout process in the `Shopping` class uses the selected payment strategy.

7. **Create a demo class that allows users to add products to the cart, view the cart's content, choose a payment strategy, and complete the checkout using the selected payment strategy:**
    - Implemented in the `Main` class.

8. **Extendability:**
    - The design allows for easy extension of new payment strategies without modifying existing code.
