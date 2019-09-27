package ru.grandsmeta.document.impl.xml;

import java.util.HashSet;
import java.util.Set;

import ru.grandsmeta.document.Document;
import ru.grandsmeta.document.Measured;
import ru.grandsmeta.document.Price;

public class XmlPrice extends XmlItem implements Price, Measured {

	public XmlPrice(Document document) {
		super(document, Consts.T_ELEM);
	}

	@Override
	public double getPriceCE() {
		return Double.parseDouble(getAttrib(Consts.A_PRICE_PRICECE));
	}

	@Override
	public double getPriceCT() {
		return Double.parseDouble(getAttrib(Consts.A_PRICE_PRICECT));
	}

	@Override
	public double getPriceBE() {
		return Double.parseDouble(getAttrib(Consts.A_PRICE_PRICEBE));
	}

	@Override
	public double getPriceBT() {
		return Double.parseDouble(getAttrib(Consts.A_PRICE_PRICEBT));
	}

	@Override
	public void setPriceCE(double priceCE) {
		setAttrib(Consts.A_PRICE_PRICECE, Double.toString(priceCE));
	}

	@Override
	public void setPriceCT(double priceCT) {
		setAttrib(Consts.A_PRICE_PRICECT, Double.toString(priceCT));
	}

	@Override
	public void setPriceBE(double priceBE) {
		setAttrib(Consts.A_PRICE_PRICEBE, Double.toString(priceBE));
	}

	@Override
	public void setPriceBT(double priceBT) {
		setAttrib(Consts.A_PRICE_PRICEBT, Double.toString(priceBT));
	}

	@Override
	public void setCurrentPriceComment(String value) {
		setAttrib(Consts.A_PRICE_PRICECURRCOMMENT, value);
	}

	@Override
	public void setBasePriceComment(String value) {
		setAttrib(Consts.A_PRICE_PRICEBASECOMMENT, value);

	}

	@Override
	public void setMeasure(String value) {
		setAttrib(Consts.A_PRICE_MEASURE, value);
	}

	@Override
	public void setComment(String value) {
		setAttrib(Consts.A_PRICE_COMMENT, value);
	}

	@Override
	public String getCurrentPriceComment() {
		return getAttrib(Consts.A_PRICE_PRICECURRCOMMENT);
	}

	@Override
	public String getBasePriceComment() {
		return getAttrib(Consts.A_PRICE_PRICEBASECOMMENT);
	}

	@Override
	public String getMeasure() {
		return getAttrib(Consts.A_PRICE_MEASURE);
	}

	@Override
	public String getComment() {
		return getAttrib(Consts.A_PRICE_COMMENT);
	}

	@Override
	protected Set<String> getAttribs() {
		Set<String> attribs = new HashSet<String>();
		attribs.add(Consts.A_PRICE_CAPTION);
		attribs.add(Consts.A_PRICE_CODE);
		attribs.add(Consts.A_PRICE_MEASURE);
		attribs.add(Consts.A_PRICE_COMMENT);
		attribs.add(Consts.A_PRICE_PRICEBASECOMMENT);
		attribs.add(Consts.A_PRICE_PRICEBE);
		attribs.add(Consts.A_PRICE_PRICEBT);
		attribs.add(Consts.A_PRICE_PRICECE);
		attribs.add(Consts.A_PRICE_PRICECT);
		attribs.add(Consts.A_PRICE_PRICECURRCOMMENT);
		attribs.add(Consts.A_PRICE_CARGO);
		attribs.add(Consts.A_PRICE_MASS);
		attribs.add(Consts.A_PRICE_OKP);
		attribs.add(Consts.A_PRICE_WORKERCLASS);
		return attribs;
	}

	@Override
	protected boolean needToSave() {
		return true;
	}

	@Override
	protected XmlItem newItem(String xmlTag) {
		return null;
	}

	@Override
	public double getMass() {
		return Double.parseDouble(getAttrib(Consts.A_PRICE_MASS));
	}

	@Override
	public String getOKP() {
		return getAttrib(Consts.A_PRICE_OKP);
	}

	@Override
	public double getWorkerClass() {
		return Double.parseDouble(getAttrib(Consts.A_PRICE_WORKERCLASS));
	}

	@Override
	public void setMass(double value) {
		setAttrib(Consts.A_PRICE_MASS, Double.toString(value));
	}

	@Override
	public void setOKP(String value) {
		setAttrib(Consts.A_PRICE_OKP, value);		
	}

	@Override
	public void setWorkerClass(double value) {
		setAttrib(Consts.A_PRICE_WORKERCLASS, Double.toString(value));		
	}

	@Override
	public int getCargoClass() {
		return Integer.parseInt(getAttrib(Consts.A_PRICE_CARGO));
	}

	@Override
	public void setCargoClass(int value) {
		setAttrib(Consts.A_PRICE_CARGO, Integer.toString(value));		
	}

}
