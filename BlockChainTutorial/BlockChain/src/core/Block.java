package core;

import java.util.ArrayList;

import util.Util;

public class Block {

	private int blockID;
	private String previousBlockHash;
	private int nonce;
	private ArrayList<Transaction>transactionList;
	
	public int getBlockID() {
		return blockID;
	}
	public void setBlockID(int blockID) {
		this.blockID = blockID;
	}
	public String getPreviousBlockHash() {
		return previousBlockHash;
	}
	public void setPreviousBlockHash(String previousBlockHash) {
		this.previousBlockHash = previousBlockHash;
	}
	public int getNonce() {
		return nonce;
	}
	public void setNonce(int nonce) {
		this.nonce = nonce;
	}
	public Block(int blockID, String previousBlockHash, int nonce, ArrayList transactionList) {
		super();
		this.blockID = blockID;
		this.previousBlockHash = previousBlockHash;
		this.nonce = nonce;
		this.transactionList = transactionList;
	}
	
	public void addTransaction(Transaction transaction) {
		transactionList.add(transaction);
	}
	
	public void getInformation() {
		System.out.println("-----------------------------------------");
		System.out.println("블록 번호: " + getBlockID());
		System.out.println("이전 해시: " + getPreviousBlockHash());
		System.out.println("채굴 변수 값: " + getNonce());
		System.out.println("트랜잭션 개수: " + transactionList.size());
		for (int i = 0; i < transactionList.size(); i++) {
			System.out.println(transactionList.get(i).getInformation());
		}
		System.out.println("블록 해시: " + getBlockHash());
		System.out.println("-----------------------------------------");
	}
	/** 
	 * nonce + transactionInformations + previousBlockHash 를 
	 * 모두 더한값으로 해쉬값 결정 
	 * */
	public String getBlockHash() {
		String transactionInformations = ""; // 이전까지의 트랜잭션 정보 모두 담는 변수
		for (int i = 0; i < transactionList.size(); i++) {
			transactionInformations += transactionList.get(i).getInformation();
		}
		return Util.getHash(nonce + transactionInformations + previousBlockHash);
	}
	
	public void mine() {
		while(true) {
			if(getBlockHash().substring(0, 4).equals("0000")) {
				System.out.println(blockID + "번째 블록의 채굴에 성공했습니다.");
				break;
			}
			nonce++;
		}
	}
	
}
