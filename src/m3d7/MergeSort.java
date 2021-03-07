package m3d7;

import java.util.Arrays;

public class MergeSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr= {8,4,6,2,1,3,5,7};
		int[] temp=new int[arr.length];
		mergeSort(arr,0,arr.length-1,temp);
		
		System.out.println(Arrays.toString(arr));
	}
	
	public static void mergeSort(int[] arr,int left,int right,int[] temp) {
		if(left < right) {
			int mid=(left+right)/2;
			//向左递归进行分解
			mergeSort(arr,left,mid,temp);
			//向右递归进行分解
			mergeSort(arr,mid+1,right,temp);
			
			merge(arr,left,mid,right,temp);
		}
	}
	
	
	public static void merge(int[] arr,int left,int mid,int right,int[] temp) {
		int i=left;//表示左边有序序列的第一个元素下标
		int j=mid+1;//表示右边有序序列的第一个元素下标
		int t=0;//指向temp数组的当前下标
		
		//把左右两边的数据按规则填充到temp数组
		//直到左右两边有序序列有一边处理完毕为止
		while(i<=mid&&j<=right) {
			//如果左边有序序列的当前元素<=右边有序序列的当前元素
			//	就把左边的当前元素拷贝到temp第一个位置，比较后后移
			//否则就把右边的放到temp中
			if(arr[i]<=arr[j]) {
				temp[t]=arr[i];
				t++;
				i++;
			}else {
				temp[t]=arr[j];
				t++;
				j++;
			}
		}
		
		//把剩余数据全部填充到temp后面
		while(i<=mid) {
			temp[t]=arr[i];
			t++;
			i++;
		}
		while(j<=right) {
			temp[t]=arr[j];
			t++;
			j++;
		}
		//将temp数组拷贝到arr
		t=0;
		int tempLeft=left;
		while(tempLeft<=right) {
			arr[tempLeft]=temp[t];
			t++;
			tempLeft++;
		}
	}
	
}
