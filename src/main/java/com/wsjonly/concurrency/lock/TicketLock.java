package com.wsjonly.concurrency.lock;

import java.util.concurrent.atomic.AtomicInteger;

public class TicketLock {
	private AtomicInteger serciceNum = new AtomicInteger();
	private AtomicInteger ticketNum = new AtomicInteger();
	
	public int lock() {
		int nextTicketNum = ticketNum.getAndIncrement();
		while (serciceNum.get() != nextTicketNum) {
			
		}
		return nextTicketNum;
	}
	
	public void unlock(int nowTicket) {
		int next = nowTicket + 1;
		while (serciceNum.compareAndSet(nowTicket, next)){
			
		}
	}
	
}
