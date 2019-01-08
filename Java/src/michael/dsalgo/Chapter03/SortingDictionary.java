package michael.dsalgo.Chapter03;

public class SortingDictionary {

    // Do it
    public static void insertionSort01(int[] a) { // Time Complexity : O(n^2)
        for (int i = 0; i < a.length; i++) { // outer loop - 각 원소들이 한번씩 순서가 오게 함
            int j;
            int tmp = a[i];
            for (j = i; j > 0 && a[j - 1] > tmp; j--) // inner loop - 적절한 자리를 찾아들어가게 함
                // 한칸씩 뒤로 미는 방법
                a[j] = a[j - 1];
            a[j] = tmp;
        }
    }

    // DS and ALGO in Java (Do it 보다 아주 미세하게 개선됨)
    public static void insertionSort02(int[] a) {
        int n = a.length;
        for (int i = 1; i < n; i++) { // 첫번째 원소는 그냥 지나쳐도 됨
            int cur = a[i]; // 현재 insertionSort 중인 원소
            int j = i - 1; // 현재 선택한 원소 이전에 있는 배열에 대해서
            while ((j >= 0) && (a[j] > cur)) // j >= 0 이고 a[j] > cur 일 동안 반복
                // => cur 보다 큰 원소를 한칸씩 뒤로 민다.
                // j는 cur 보다 작은 원소의 index 가 저장된다.
                a[j + 1] = a[j--];
            a[j + 1] = cur; // cur 보다 작은 원소의 바로 뒤에 cur을 삽입
        }
    }
}
