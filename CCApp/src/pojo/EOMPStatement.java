package pojo;

public class EOMPStatement {

	private int statementNo;
	private Double minAmountDue;
	private Double totalAmountDue;
	private Double interestDue;

	public int getStatementNo() {
		return statementNo;
	}

	public void setStatementNo(int statementNo) {
		this.statementNo = statementNo;
	}

	public Double getMinAmountDue() {
		return minAmountDue;
	}

	public void setMinAmountDue(Double minAmountDue) {
		this.minAmountDue = minAmountDue;
	}

	public Double getTotalAmountDue() {
		return totalAmountDue;
	}

	public void setTotalAmountDue(Double totalAmountDue) {
		this.totalAmountDue = totalAmountDue;
	}

	public Double getInterestDue() {
		return interestDue;
	}

	public void setInterestDue(Double interestDue) {
		this.interestDue = interestDue;
	}

}
