package com.wsjonly.concurrency.lock;

import java.util.concurrent.atomic.AtomicReference;

class CLHSpinLock {
	private final ThreadLocal<Node> prev;
	private final ThreadLocal<Node> node;
	private final AtomicReference<Node> tail = new AtomicReference<Node>(new Node());

	public CLHSpinLock() {
		this.node = new ThreadLocal<Node>() {
			protected Node initialValue() {
				return new Node();
			}
		};

		this.prev = new ThreadLocal<Node>() {
			protected Node initialValue() {
				return null;
			}
		};
	}

	public void lock() {
		final Node node = this.node.get();
		node.locked = true;
		// һ��CAS�������ɽ���ǰ�̶߳�Ӧ�Ľڵ���뵽�����У�
		// ����ͬʱ�����ǰ�̽ڵ�����ã�Ȼ����ǵȴ�ǰ���ͷ���
		Node pred = this.tail.getAndSet(node);
		this.prev.set(pred);
		while (pred.locked) {// ��������
		}
	}

	public void unlock() {
		final Node node = this.node.get();
		node.locked = false;
		this.node.set(this.prev.get());
	}

	private static class Node {
		private volatile boolean locked;
	}
}