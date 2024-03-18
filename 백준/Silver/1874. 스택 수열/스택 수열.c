#include <stdio.h>
#include <stdlib.h>
#define MAX_SIZE 100000

// global variables
int stack[MAX_SIZE];
int top = -1;

int main() {
    int n;
    scanf("%d", &n);

    int* arr = (int*)malloc(sizeof(int) * n);
    for (int i = 0; i < n; i++)
        scanf("%d", &arr[i]);

    int cur = 1;
    int arr_idx = 0;
    char result_arr[MAX_SIZE * 2];
    int res_idx = 0;

    while (arr_idx < n) {
        if (top ==  -1 || stack[top] < arr[arr_idx]) {
            while (cur <= n && cur <= arr[arr_idx]) {
                stack[++top] = cur++;
                result_arr[res_idx++] = '+';
            }
        }
        
        else if (stack[top] == arr[arr_idx]) {
            top--;
            result_arr[res_idx++] = '-';
            arr_idx++;
        }
        
        else {
            printf("NO\n");
            return 0;
        }
    }

    for (int i = 0; i < res_idx; i++)
        printf("%c\n", result_arr[i]);

    return 0;
}
