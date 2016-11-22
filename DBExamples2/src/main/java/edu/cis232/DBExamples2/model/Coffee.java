package edu.cis232.DBExamples2.model;

public class Coffee {
	String description;
	String prodNum;
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getProdNum() {
		return prodNum;
	}

	public void setProdNum(String prodNum) {
		this.prodNum = prodNum;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	double price;
	
	public Coffee(String description, String prodNum, double price){
		this.description = description;
		this.prodNum = prodNum;
		this.price = price;
	}
	
	public String toString(){
		return String.format("%10s %25s $%4.2f", prodNum, description, price);
	}
}
