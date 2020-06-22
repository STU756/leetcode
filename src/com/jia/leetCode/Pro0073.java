package com.jia.leetCode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class Pro0073 {
    public void setZeroes(int[][] matrix) {
    	if(matrix == null || matrix.length == 0 || matrix[0].length ==0) {
    		return ;
    	}
    	int m = matrix.length;
    	int n = matrix[0].length;
    	boolean rowZero = false;
    	boolean colZero = false;
    	for(int i=0; i<n; i++) {
    	    if(matrix[0][i] == 0) {
    	        rowZero = true;
    	        break;
    	    }
    	}
    	for(int i =0;i <m; i++) {
    	    if(matrix[i][0] == 0) {
    	        colZero = true;
    	        break;
    	    }
    	}
    	for(int i=1; i<m; i++) {
    		for(int j=1; j<n; j++) {
    			if(matrix[i][j] == 0){
    				matrix[i][0] = 0;
    				matrix[0][j] = 0;
    			}
    		}
    	}
    	for(int i=1; i<m; i++) {
    		for(int j=1; j<n; j++) {
    			if(matrix[0][j] == 0 || matrix[i][0]==0 ){
    				matrix[i][j] = 0;
    			}
    		}
    	}
    	if(rowZero) {
    	    for(int i=0; i<n; i++) {
    	        matrix[0][i] = 0;
    	    }
    	}
    	if(colZero) {
    	    for(int i=0; i<m; i++) {
    	        matrix[i][0] = 0;
    	    }
    	}
    }
    public static void main(String[] args) {
		int[][] a = {{1,1,1},
					 {2,2,2},
					 {3,3,3},
					 {4,4,4}};
		System.out.println(a.length + " " + a[0].length);
	}
}
