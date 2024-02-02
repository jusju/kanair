package engine;

public class Lentokentta {
	private String kutsukoodi;
	private double polttoaine100LL;
	private double jetA1;
	private double mogas98;
	public Lentokentta(String kutsukoodi, double polttoaine100ll, double jetA1, double mogas98) {
		super();
		this.kutsukoodi = kutsukoodi;
		polttoaine100LL = polttoaine100ll;
		this.jetA1 = jetA1;
		this.mogas98 = mogas98;
	}
	public String getKutsukoodi() {
		return kutsukoodi;
	}
	public void setKutsukoodi(String kutsukoodi) {
		this.kutsukoodi = kutsukoodi;
	}
	public double getPolttoaine100LL() {
		return polttoaine100LL;
	}
	public void setPolttoaine100LL(double polttoaine100ll) {
		polttoaine100LL = polttoaine100ll;
	}
	public double getJetA1() {
		return jetA1;
	}
	public void setJetA1(double jetA1) {
		this.jetA1 = jetA1;
	}
	public double getMogas98() {
		return mogas98;
	}
	public void setMogas98(double mogas98) {
		this.mogas98 = mogas98;
	}
	
	
	
	
}
