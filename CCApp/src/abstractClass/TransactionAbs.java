package abstractClass;

import enums.TransactionType;
import interfaces.Transaction;

public abstract class TransactionAbs implements Transaction {

	protected Double transactionAmount;
	protected TransactionType txnType;

	public Double getTransactionAmount() {
		return transactionAmount;
	}

	public void setTransactionAmount(Double transactionAmount) {
		this.transactionAmount = transactionAmount;
	}

	public TransactionType getTxnType() {
		return txnType;
	}

	public void setTxnType(TransactionType txnType) {
		this.txnType = txnType;
	}

}
