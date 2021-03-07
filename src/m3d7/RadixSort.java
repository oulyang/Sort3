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
		//�õ��������������λ��
		int max=arr[0];
		for(int i=1;i<arr.length;i++) {
			if(arr[i]>max) {
				max=arr[i];
			}
		}
		//��int��ת��String�����䳤��
		int maxLength=(max+"").length();
		
		int[][] bucket=new int[10][arr.length];
		int[] bucketElementCounts=new int[10];
		
		
		for(int i=0,n=1;i<maxLength;i++,n*=10) {
			for(int j=0;j<arr.length;j++) {
				//ȡ��ÿ��Ԫ�ص�λ��
				int digitOfElement=arr[j] /n% 10;
				//�����Ӧ��Ͱ��
				bucket[digitOfElement][bucketElementCounts[digitOfElement]]=arr[j];
				bucketElementCounts[digitOfElement]++;
			}
			
			//����Ͱ��˳��һά������±�����ȡ�����ݷ���ԭ��������arr��
			int index=0;
			//����ÿһ��Ͱ��ȡ�����ݷ���arr
			for(int k=0;k<bucketElementCounts.length;k++) {
				//�ж�Ͱ���Ƿ�������
				if(bucketElementCounts[k]!=0){
					//ѭ����ȡ��Ͱ�е�����Ԫ��
					for(int l=0;l<bucketElementCounts[k];l++) {
						arr[index]=bucket[k][l];
						index++;
					}
				}
				//��һ�ִ������Ҫ��ÿ��bucketElementCounts[k]���¸�ֵ0
				bucketElementCounts[k]=0;
			}
			System.out.println("��"+(i+1)+"��"+Arrays.toString(arr));
		}
	}
	
	

	public static void radixSort1(int[] arr) {
		//�Ը�λ������������
		//������ά�����ʾ10��Ͱ��ÿ��Ͱ�Ǹ�һά����,Ϊ�˷�ֹ���������һά�����СΪarr.length
		int[][] bucket=new int[10][arr.length];
		//��¼ÿ��Ͱ�з��˶��ٸ�����
		//bucketElementCounts[0]��ʾbucket[0]�е�Ԫ�ظ���
		int[] bucketElementCounts=new int[10];
		
		//��һ��
		for(int j=0;j<arr.length;j++) {
			//ȡ��ÿ��Ԫ�صĸ�λ��
			int digitOfElement=arr[j] % 10;
			//�����Ӧ��Ͱ��
			bucket[digitOfElement][bucketElementCounts[digitOfElement]]=arr[j];
			bucketElementCounts[digitOfElement]++;
		}
		
		//����Ͱ��˳��һά������±�����ȡ�����ݷ���ԭ��������arr��
		int index=0;
		//����ÿһ��Ͱ��ȡ�����ݷ���arr
		for(int k=0;k<bucketElementCounts.length;k++) {
			//�ж�Ͱ���Ƿ�������
			if(bucketElementCounts[k]!=0){
				//ѭ����ȡ��Ͱ�е�����Ԫ��
				for(int l=0;l<bucketElementCounts[k];l++) {
					arr[index]=bucket[k][l];
					index++;
				}
			}
			//��һ�ִ������Ҫ��ÿ��bucketElementCounts[k]���¸�ֵ0
			bucketElementCounts[k]=0;
		}
		System.out.println("��һ��"+Arrays.toString(arr));
		
		//�ڶ���
		for(int j=0;j<arr.length;j++) {
			//ȡ��ÿ��Ԫ�صĸ�λ��
			int digitOfElement=arr[j] / 10 % 10;
			//�����Ӧ��Ͱ��
			bucket[digitOfElement][bucketElementCounts[digitOfElement]]=arr[j];
			bucketElementCounts[digitOfElement]++;
		}
		
		//����Ͱ��˳��һά������±�����ȡ�����ݷ���ԭ��������arr��
		index=0;
		//����ÿһ��Ͱ��ȡ�����ݷ���arr
		for(int k=0;k<bucketElementCounts.length;k++) {
			//�ж�Ͱ���Ƿ�������
			if(bucketElementCounts[k]!=0){
				//ѭ����ȡ��Ͱ�е�����Ԫ��
				for(int l=0;l<bucketElementCounts[k];l++) {
					arr[index]=bucket[k][l];
					index++;
				}
			}
			bucketElementCounts[k]=0;
		}
		System.out.println("�ڶ���"+Arrays.toString(arr));

		//������
		for(int j=0;j<arr.length;j++) {
			//ȡ��ÿ��Ԫ�ص�ʮλ��
			int digitOfElement=arr[j]/100%10;
			//�����Ӧ��Ͱ��
			bucket[digitOfElement][bucketElementCounts[digitOfElement]]=arr[j];
			bucketElementCounts[digitOfElement]++;
		}
		
		//����Ͱ��˳��һά������±�����ȡ�����ݷ���ԭ��������arr��
		index=0;
		//����ÿһ��Ͱ��ȡ�����ݷ���arr
		for(int k=0;k<bucketElementCounts.length;k++) {
			//�ж�Ͱ���Ƿ�������
			if(bucketElementCounts[k]!=0){
				//ѭ����ȡ��Ͱ�е�����Ԫ��
					for(int l=0;l<bucketElementCounts[k];l++) {
						arr[index++]=bucket[k][l];
					}
				}
				bucketElementCounts[k]=0;
			}
		System.out.println("������"+Arrays.toString(arr));
	}
}
