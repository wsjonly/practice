package com.wsjonly.concurrency;

import java.util.concurrent.locks.ReentrantLock;

class Reader2 extends Thread {

	private BufferInterruptibly buff;

	public Reader2(BufferInterruptibly buff) {
		this.buff = buff;
	}

	@Override
	public void run() {

		try {
			buff.read();// �����յ��жϵ��쳣���Ӷ���Ч�˳�
		} catch (InterruptedException e) {
			System.out.println("�Ҳ�����");
		}

		System.out.println("������");

	}
}

class Writer2 extends Thread {

	private BufferInterruptibly buff;

	public Writer2(BufferInterruptibly buff) {
		this.buff = buff;
	}

	@Override
	public void run() {
		buff.write();
	}

}

public class BufferInterruptibly {

	private ReentrantLock lock = new ReentrantLock();

	public void write() {
		lock.lock();
		try {
			long startTime = System.currentTimeMillis();
			System.out.println("��ʼ�����buffд�����ݡ�");
			for (;;)// ģ��Ҫ����ܳ�ʱ��
			{
				if (System.currentTimeMillis() - startTime > Integer.MAX_VALUE) {
					break;
				}
			}
			System.out.println("����д����");
		} finally {
			lock.unlock();
		}
	}

	public void read() throws InterruptedException {
		lock.lockInterruptibly();// ע�����������Ӧ�ж�
//		lock.lock();
		try {
			System.out.println("�����buff������");
		} finally {
			lock.unlock();
		}
	}

	public static void main(String args[]) {
		BufferInterruptibly buff = new BufferInterruptibly();

		final Writer2 writer = new Writer2(buff);
		final Reader2 reader = new Reader2(buff);

		writer.start();
		reader.start();

		new Thread(new Runnable() {

			@Override
			public void run() {
				long start = System.currentTimeMillis();
				for (;;) {
					if (System.currentTimeMillis() - start > 5000) {
						System.out.println("�����ˣ������ж�");
						reader.interrupt(); // �˴��ж϶�����
						break;
					}
				}
			}
		}).start();

	}
}
