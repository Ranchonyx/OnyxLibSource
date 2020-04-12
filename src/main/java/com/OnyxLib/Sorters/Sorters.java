package com.OnyxLib.Sorters;

public class Sorters {

	public Sorters() {}
	
	public static int[] selectionSort(int[] oof) {
		int[] elements = oof;
		int l = 0;
		int n = elements.length;
		
		
		while(l < n) {
			int min = l;
			for(int i = l+1; i < n; i++) {
				if(elements[i] < elements[min]) {
					min = i;
				}
			}
			int tmp = elements[min];
			elements[min] = elements[l];
			elements[l] = tmp;
			l++;
		}
		return elements;
	}
	
	public static void swap(int[] arr, int f, int g) {
		int tmp = f;
		arr[f] = arr[g];
		arr[g] = tmp;
	}
	
	
//	@Deprecated
//	public static int[] insertionSort(int[] oof) {
//		int[] elements = oof;
//		for(int i = 1; i < elements.length-1; i++) {
//			int mem = elements[i];
//			int j =1;
//			while(j > 0 && (elements[j -1] > mem)) {
//				elements[j] = elements[j-1];
//				j--;
//			}
//			elements[j] = mem;
//		}
//		for(int i = 0; i < oof.length; i++) {
//			System.out.println(elements[i]);
//		}
//		return elements;
//	}

	
	}
