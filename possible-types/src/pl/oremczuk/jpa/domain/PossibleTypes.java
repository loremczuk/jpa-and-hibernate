package pl.oremczuk.jpa.domain;

import java.math.BigDecimal;
import java.math.BigInteger;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;

@Entity
public class PossibleTypes {
	
	@Id
	private long ID;
	
	private short someShort;
	private double someDouble;
	private int someInt;
	private boolean someBoolean;
	private char someChar;
	private float someFloat;
	
	@Transient
	private int ignoredField;
	
	
	private Integer someInteger;
	private BigDecimal bigDecimal;
	private BigInteger bigInteger;
	private Double someDoubleClass;
	
	public Double getSomeDoubleClass() {
		return someDoubleClass;
	}
	public void setSomeDoubleClass(Double someDoubleClass) {
		this.someDoubleClass = someDoubleClass;
	}
	private int[] intArray;
	private double[] doubleArray;
	private MyEnum myEnum;
	
	
	public MyEnum getMyEnum() {
		return myEnum;
	}
	public void setMyEnum(MyEnum myEnum) {
		this.myEnum = myEnum;
	}
	public long getID() {
		return ID;
	}
	public void setID(long iD) {
		ID = iD;
	}
	public short getSomeShort() {
		return someShort;
	}
	public void setSomeShort(short someShort) {
		this.someShort = someShort;
	}
	public double getSomeDouble() {
		return someDouble;
	}
	public void setSomeDouble(double someDouble) {
		this.someDouble = someDouble;
	}
	public int getSomeInt() {
		return someInt;
	}
	public void setSomeInt(int someInt) {
		this.someInt = someInt;
	}
	public boolean isSomeBoolean() {
		return someBoolean;
	}
	public void setSomeBoolean(boolean someBoolean) {
		this.someBoolean = someBoolean;
	}
	public char getSomeChar() {
		return someChar;
	}
	public void setSomeChar(char someChar) {
		this.someChar = someChar;
	}
	public float getSomeFloat() {
		return someFloat;
	}
	public void setSomeFloat(float someFloat) {
		this.someFloat = someFloat;
	}
	public int getIgnoredField() {
		return ignoredField;
	}
	public void setIgnoredField(int ignoredField) {
		this.ignoredField = ignoredField;
	}
	public Integer getInteger() {
		return someInteger;
	}
	public void setInteger(Integer someInteger) {
		this.someInteger = someInteger;
	}
	public BigDecimal getBigDecimal() {
		return bigDecimal;
	}
	public void setBigDecimal(BigDecimal bigDecimal) {
		this.bigDecimal = bigDecimal;
	}
	public BigInteger getBigInteger() {
		return bigInteger;
	}
	public void setBigInteger(BigInteger bigInteger) {
		this.bigInteger = bigInteger;
	}
	public int[] getIntArray() {
		return intArray;
	}
	public void setIntArray(int[] intArray) {
		this.intArray = intArray;
	}
	public double[] getDoubleArray() {
		return doubleArray;
	}
	public void setDoubleArray(double[] doubleArray) {
		this.doubleArray = doubleArray;
	}
	
	
	
	
	

}
