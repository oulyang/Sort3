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
			//����ݹ���зֽ�
			mergeSort(arr,left,mid,temp);
			//���ҵݹ���зֽ�
			mergeSort(arr,mid+1,right,temp);
			
			merge(arr,left,mid,right,temp);
		}
	}
	
	
	public static void merge(int[] arr,int left,int mid,int right,int[] temp) {
		int i=left;//��ʾ����������еĵ�һ��Ԫ���±�
		int j=mid+1;//��ʾ�ұ��������еĵ�һ��Ԫ���±�
		int t=0;//ָ��temp����ĵ�ǰ�±�
		
		//���������ߵ����ݰ�������䵽temp����
		//ֱ��������������������һ�ߴ������Ϊֹ
		while(i<=mid&&j<=right) {
			//�������������еĵ�ǰԪ��<=�ұ��������еĵ�ǰԪ��
			//	�Ͱ���ߵĵ�ǰԪ�ؿ�����temp��һ��λ�ã��ȽϺ����
			//����Ͱ��ұߵķŵ�temp��
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
		
		//��ʣ������ȫ����䵽temp����
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
		//��temp���鿽����arr
		t=0;
		int tempLeft=left;
		while(tempLeft<=right) {
			arr[tempLeft]=temp[t];
			t++;
			tempLeft++;
		}
	}
	
}
