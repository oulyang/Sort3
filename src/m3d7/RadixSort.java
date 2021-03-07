package m3d7;

import java.util.Arrays;

public class RadixSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr= {55,123,151,777,12,666};
		//radixSort1(arr);
		//System.out.println(Arrays.toString(arr));
		
		radixSort2(arr);
	}
	public static void radixSort2(int[] arr) {
		//得到数组中最大数的位数
		int max=arr[0];
		for(int i=1;i<arr.length;i++) {
			if(arr[i]>max) {
				max=arr[i];
			}
		}
		//将int型转成String再求其长度
		int maxLength=(max+"").length();
		
		int[][] bucket=new int[10][arr.length];
		int[] bucketElementCounts=new int[10];
		
		
		for(int i=0,n=1;i<maxLength;i++,n*=10) {
			for(int j=0;j<arr.length;j++) {
				//取出每个元素的位数
				int digitOfElement=arr[j] /n% 10;
				//放入对应的桶中
				bucket[digitOfElement][bucketElementCounts[digitOfElement]]=arr[j];
				bucketElementCounts[digitOfElement]++;
			}
			
			//按照桶的顺序（一维数组的下标依次取出数据放入原来的数组arr）
			int index=0;
			//遍历每一个桶，取出数据放入arr
			for(int k=0;k<bucketElementCounts.length;k++) {
				//判断桶中是否有数据
				if(bucketElementCounts[k]!=0){
					//循环获取该桶中的所有元素
					for(int l=0;l<bucketElementCounts[k];l++) {
						arr[index]=bucket[k][l];
						index++;
					}
				}
				//第一轮处理后需要将每个bucketElementCounts[k]重新赋值0
				bucketElementCounts[k]=0;
			}
			System.out.println("第"+(i+1)+"轮"+Arrays.toString(arr));
		}
	}
	
	

	public static void radixSort1(int[] arr) {
		//对个位数进行排序处理
		//创建二维数组表示10个桶，每个桶是个一维数组,为了防止数据溢出，一维数组大小为arr.length
		int[][] bucket=new int[10][arr.length];
		//记录每个桶中放了多少个数据
		//bucketElementCounts[0]表示bucket[0]中的元素个数
		int[] bucketElementCounts=new int[10];
		
		//第一轮
		for(int j=0;j<arr.length;j++) {
			//取出每个元素的个位数
			int digitOfElement=arr[j] % 10;
			//放入对应的桶中
			bucket[digitOfElement][bucketElementCounts[digitOfElement]]=arr[j];
			bucketElementCounts[digitOfElement]++;
		}
		
		//按照桶的顺序（一维数组的下标依次取出数据放入原来的数组arr）
		int index=0;
		//遍历每一个桶，取出数据放入arr
		for(int k=0;k<bucketElementCounts.length;k++) {
			//判断桶中是否有数据
			if(bucketElementCounts[k]!=0){
				//循环获取该桶中的所有元素
				for(int l=0;l<bucketElementCounts[k];l++) {
					arr[index]=bucket[k][l];
					index++;
				}
			}
			//第一轮处理后需要将每个bucketElementCounts[k]重新赋值0
			bucketElementCounts[k]=0;
		}
		System.out.println("第一轮"+Arrays.toString(arr));
		
		//第二轮
		for(int j=0;j<arr.length;j++) {
			//取出每个元素的个位数
			int digitOfElement=arr[j] / 10 % 10;
			//放入对应的桶中
			bucket[digitOfElement][bucketElementCounts[digitOfElement]]=arr[j];
			bucketElementCounts[digitOfElement]++;
		}
		
		//按照桶的顺序（一维数组的下标依次取出数据放入原来的数组arr）
		index=0;
		//遍历每一个桶，取出数据放入arr
		for(int k=0;k<bucketElementCounts.length;k++) {
			//判断桶中是否有数据
			if(bucketElementCounts[k]!=0){
				//循环获取该桶中的所有元素
				for(int l=0;l<bucketElementCounts[k];l++) {
					arr[index]=bucket[k][l];
					index++;
				}
			}
			bucketElementCounts[k]=0;
		}
		System.out.println("第二轮"+Arrays.toString(arr));

		//第三轮
		for(int j=0;j<arr.length;j++) {
			//取出每个元素的十位数
			int digitOfElement=arr[j]/100%10;
			//放入对应的桶中
			bucket[digitOfElement][bucketElementCounts[digitOfElement]]=arr[j];
			bucketElementCounts[digitOfElement]++;
		}
		
		//按照桶的顺序（一维数组的下标依次取出数据放入原来的数组arr）
		index=0;
		//遍历每一个桶，取出数据放入arr
		for(int k=0;k<bucketElementCounts.length;k++) {
			//判断桶中是否有数据
			if(bucketElementCounts[k]!=0){
				//循环获取该桶中的所有元素
					for(int l=0;l<bucketElementCounts[k];l++) {
						arr[index++]=bucket[k][l];
					}
				}
				bucketElementCounts[k]=0;
			}
		System.out.println("第三轮"+Arrays.toString(arr));
	}
}
