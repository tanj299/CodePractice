export interface Product {
    name: string; 
    unitPrice: number;
} 

export interface OrderDetail {
    product: Product;
    quantity: number;
    getTotal(discount: number): number;
} 

const table: Product = {
    name: "Table",
    unitPrice: 500,
}

const tableOrder: OrderDetail = {
    product: table, 
    quantity: 1,
    getTotal(discount: number): number {
        const priceWithoutDiscount = this.product.unitPrice * this.quantity;
        const discountAmount = priceWithoutDiscount * discount;
        return discountAmount;
    }
}