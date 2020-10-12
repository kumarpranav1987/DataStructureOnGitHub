package com.pranav.hackerearth;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ShortestPathProblem {

	public static void main(String[] args) throws IOException {
		String[] expected = "0 0 93 95 69 98 93 61 64 96 81 92 74 53 93 87 89 64 65 81 60 87 75 79 69 87 71 102 57 77 85 94 88 82 91 73 50 84 94 82 76 80 28 83 56 52 92 30 95 102 90 56 98 89 108 101 63 82 96 95 94 84 74 63 92 95 77 55 58 65 80 68 86 56 60 97 74 85 68 99 78 103 85 64 49 84 81 78 77 46 87 69 81 92 64 76 86 62 61 68 58 65 88 107 92 71 40 81 87 98 90 90 76 93 70 73 69 56 102 62 111 79 95 82 78 73 71 80 87 74 64 77 105 79 71 75 71 71 46 85 56 73 78 78 91 63 48 92 66 70 68 80 82 75 75 87 91 90 78 66 84 103 67 77 41 68 38 67 89 68 89 64 73 82 64 108 109 69 115 77 82 80 77 55 107 67 56 85 69 77 71 59 46 83 71 55 84 86 57 79 81 116 81 79 75 63 127 50 76 90 68 67 68 68 46 65 81 50 63 71 57 86 94 70 84 82 105 88 59 64 76 86 54 85 100 81 87 85 85 46 64 88 77 50 106 57 87 75 70 106 90 93 57 58 71 77 62 86 70 81 81 63 49 76 83 79 30 71 111 60 67 75 94 87 62 79 84 105 32 80 67 86 68 57 71 69 88 94 97 72 80 81 81 79 72 88 86 80 72 36 75 87 75 67 86 96 55 76 100 76 71 63 83 82 70 78 60 81 83 66 63 68 89 89 80 85 71 88 70 92 85 108 55 38 68 49 24 78 50 79 62 69 83 91 86 89 79 97 99 80 83 52 97 80 49 79 79 104 91 83 71 65 99 89 66 81 81 84 87 66 85 89 94 124 82 73 66 102 71 63 72 68 64 53 90 57 77 66 91 110 76 91 53 67 79 106 81 88 79 77 90 67 80 44 63 58 67 75 76 82 77 80 67 64 90 100 70 102 64 76 84 84 86 75 91 106 80 65 48 75 55 62 90 99 75 76 99 95 76 85 83 115 55 61 111 69 74 92 46 76 75 87 81 60 82 88 78 65 85 74 90 68 79 86 79 94 64 69 89 91 56 86 55 99 61 87 55 90 89 89 84 62 86 87 71 68 79 69 105 96 73 94 81 91 59 63 93 64 88 119 73 84 68 30 56 94 83 77 86 48 80 70 86 84 82 88 62 72 80 72 76 98 69 36 94 97 87 99 84 98 103 78 97 76 108 110 72 93 84 82 80 61 98 59 88 60 61 78 74 72 89 32 68 69 80 86 46 75 123 60 69 53 57 87 92 103 81 99 82 66 88 87 75 67 69 89 61 35 64 89 60 69 81 72 74 72 88 74 91 69 146 50 62 71 102 78 99 69 81 56 75 92 64 98 95 77 85 95 77 58 96 74 80 67 74 69 88 79 62 86 92 102 97 50 84 90 72 70 111 81 86 72 90 51 70 79 87 78 55 90 82 95 73 94 71 74 79 86 87 92 85 81 55 86 73 61 89 97 72 56 71 73 74 61 74 82 72 78 63 50 72 102 86 93 84 71 75 86 77 51 86 91 83 86 82 43 51 92 74 55 64 44 48 85 55 64 93 79 79 63 94 69 70 100 57 79 68 82 65 85 78 76 66 113 57 74 101 94 52 64 81 98 67 79 80 83 100 68 88 74 52 93 102 64 65 99 71 77 64 68 39 105 86 70 86 25 88 104 81 75 97 42 79 90 72 64 52 78 95 86 104 82 78 61 78 72 86 72 103 78 86 77 69 71 85 83 61 81 72 82 99 71 102 77 66 83 50 90 71 93 74 70 81 88 63 88 113 72 50 56 85 112 66 85 100 55 63 74 78 78 92 50 80 100 55 86 110 66 72 60 77 81 77 70 85 57 81 90 82 74 75 21 79 64 88 81 72 84 72 87 54 73 70 84 74 75 41 133 85 72 101 79 87 62 63 76 113 86 60 71 76 74 83 94 87 56 94 65 83 80 84 89 82 64 67 78 78 82 85 97 93 60 77 77 61 82 99 81 53 90 49 72 83 78 55 83 108 50 95 76 66 80 24 98 24 60 64 79 82 99 79 66 104 89 103 73 84 83 83 83 76 80 51 86 65 79 151 73 56 56 38 92 75 61 68 81 65 79 73 86 73 76 107 69 77 54 64 84 54 52 92 75 75 66 81 77 28 76 68 51 92 76 65 89 82 81 74 66 79 63 66 85 76 79 56 86 100 88 114 58 83 81 74 66 44 87 62 93 66 103 97 100 68 81 77 68 95 67 72 128 87 68 73 74 75 53 68 79 42 71 80 65 55 68 69 80 79 86 23 74 83 89 100 69 109 80 74 58 77 68 82 77 76 81 87 71 87 85 66 96 60 45 91 72 89 65 69 46 86 96 113 60 62 99 79 101 83 97 81 75 79 52 84 78 78 79 87 95 72 52 68 62 90 86 87 57 81 88 67 82 95 87 75 91 86 69 67 39 89 45 77 77 86 86 55 79 73 82 83 90 68 100 76 74 77 57 91 83 88 86 92 54 70 81 99 56 95 69 54 70 102 68 61 56 86 69 77 82 61 77 72 85 87 89 84 80 73 68 69 72 72 72 65 96 75 77 47 86 92 80 23 60 87 88 83 81 47 54 90 73 94 91 68 81 76 79 61 94 62 96 78 63 77 112 84 59 108 91 63 66 83 67 71 71 94 84 87 82 90 73 95 78 82 80 68 68 42 70 67 75 66 88 115 93 72 41 72 84 88 122 62 55 110 85 73 59 82 64 87 76 94 100 73 77 88 77 99 70 87 59 96 73 73 106 67 70 83 75 121 90 58 104 62 70 93 94 64 35 66 44 73 71 81 97 72 72 60 69 71 64 70 73 63 73 84 65 56 103 80 71 96 93 73 69 85 89 50 60 67 88 94 47 93 64 94 64 78 92 59 67 91 53 77 62 95 86 58 40 88 97 115 85 81 52 27 80 66 72 68 84 83 76 61 106 71 73 68 61 82 71 63 31 112 81 57 87 38 80 61 71 71 70 55 69 71 89 68 67 77 105 79 70 56 76 86 79 89 76 73 70 119 78 68 85 73 81 118 71 72 99 63 89 98 85 56 77 67 63 53 70 69 94 63 84 86 52 68 85 128 61 59 83 33 62 88 95 86 89 89 99 78 75 103 100 67 69 86 70 59 50 88 94 108 103 74 70 83 70 65 83 66 79 51 76 64 48 56 75 86 69 105 95 65 90 84 88 112 47 69 73 86 60 83 62 62 48 74 82 78 77 41 73 69 87 89 82 55 48 84 96 38 67 112 79 77 52 87 101 89 81 72 87 83 74 56 59 63 70 83 66 64 101 82 71 62 77 76 83 96 72 76 76 111 68 90 71 74 92 87 81 82 67 71 84 54 53 60 83 77 76 73 87 71 83 75 73 55 78 58 99 71 84 59 69 80 90 93 58 116 66 67 62 112 35 81 72 49 64 82 102 95 82 42 78 80 120 55 93 74 66 78 100 69 79 75 68 103 70 88 84 81 85 74 51 75 70 95 83 82 43 76 58 108 91 92 89 54 102 61 89 102 63 70 87 79 21 88 69 81 101 80 101 71 67 49 82 54 84 45 76 93 79 85 74 82 92 77 52 87 81 54 96 69 69 74 64 70 80 78 82 64 87 85 87 76 71 93 71 60 66 84 75 77 90 74 60 63 29 58 69 73 38 70 71 69 47 107 66 91 79 71 84 82 79 109 63 91 84 94 82 91 67 74 86 59 59 93 67 97 49 69 53 52 86 115 90 86 59 88 64 83 72 60 84 83 32 65 64 77 91 98 85 63 76 83 69 99 68 88 55 91 56 91 30 88 107 97 83 103 138 86 80 55 61 54 65 73 92 92 59 83 90 92 118 97 26 55 66 68 89 86 69 72 93 72 91 63 74 68 79 77 79 55 45 123 62 114 75 81 68 97 73 70 84 61 77 59 98 61 50 92 94 77 73 98 108 76 86 91 77 69 48 70 95 85 58 68 89 74 94 60 45 73 83 71 63 67 76 29 86 54 62 78 111 57 100 90 83 66 56 61 51 85 103 90 66 36 101 73 72 15 87 77 97 68 97 112 52 51 103 98 81 78 69 58 101 60 91 86 65 85 90 46 74 76 71 75 70 84 75 86 57 50 68 48 80 62 85 65 77 38 91 56 62 82 68 96 71 99 88 14 88 68 88 52 41 60 113 90 64 97 85 78 78 78 72 83 93 103 62 104 63 62 71 67 63 65 75 81 94 69 66 92 70 82 92 83 85 72 64 71 121 101 71 90 76 89 95 69 47 97 77 77 80 61 93 96 68 111 56 96 70 96 101 66 74 58 51 66 99 100 107 101 82 90 80 73 67 85 74 91 92 53 86 84 80 39 95 86 85 41 105 84 69 79 115 30 75 23 57 71 78 71 61 58 81 65 84 105 74 68 83 55 64 76 63 77 57 62 71 95 101 73 70 80 56 57 76 77 60 79 86 75 48 69 34 74 26 60 79 90 68 47 88 78 91 74 67 73 95 69 96 76 86 73 75 93 69 73 73 63 85 110 96 99 97 85 81 80 88 92 67 92 45 104 80 68 68 80 66 84 74 86 55 67 79 104 82 87 80 83 69 101 72 25 55 79 73 91 82 67 75 50 95 56 70 69 80 57 73 83 106 102 55 94 110 69 71 87 67 94 81 65 80 84 97 61 74 72 68 61 103 91 87 105 97 58 84 79 85 93 53 88 92 69 90 53 91 97 82 74 83 86 94 84 87 70 78 77 81 83 82 86 71 81 70 72 107 91 69 80 102 74 55 93 79 64 66 45 82 61 79 83 87 63 91 71 84 75 63 93 80 54 82 58 51 79 85 88 48 50 94 86 63 74 77 99 71 54 58 82 88 99 72 83 65 50 40 94 72 58 93 93 70 34 93 61 67 70 63 64 89 80 96 53 65 113 56 92 84 68 110 93 70 90 86 78 56 103 73 67 70 67 78 85 89 73 70 59 64 71 59 83 82 80 77 64 51 89 83 75 55 44 103 61 68 59 84 92 73 61 94 74 68 72 80 69 107 102 75 54 76 68 68 101 32 49 65 71 100 122 62 81 88 92 74 113 73 93 66 97 84 88 96 69 84 96 38 86 62 38 76 82 79 84 72 82 100 65 84 84 77 61 99 88 81 50 84 70 68 83 98 110 94 97 61 73 88 38 82 66 53 78 102 110 97 83 55 53 79 65 92 96 99 82 58 66 82 84 99 95 70 68 97 79 78 86 78 69 94 81 62 53 56 90 75 93 69 62 72 77 110 54 92 71 37 62 69 67 82 101 78 78 24 78 83 68 78 49 101 42 73 59 41 91 95 67 67 76 59 76 95 88 68 98 49 113 98 47 67 89 56 119 66 83 82 72 80 72 84 73 69 83 72 41 54 66 79 100 93 43 92 56 104 57 70 74 78 70 98 51 89 82 73 91 87 64 86 76 55 77 88 67 47 52 59 75 98 73 91 80 44 76 98 86 73 76 83 75 107 83 78 86 79 67 56 75 87 87 58 53 68 65 100 89 72 75 53 91 63 72 51 106 58 48 78 84 96 76 45 74 91 79 84 75 89 92 76 100 79 76 80 59 102 82 58 74 72 64 117 101 62 91 90 102 62 68 75 84 66 48 95 67 94 67 65 103 85 88 71 95 64 115 49 97 88 63 119 105 82 89 61 103 66 78 72 57 67 56 92 71 82 97 98 66 78 106 88 65 79 81 98 76 74 73 81 61 42 79 82 71 74 96 71 85 65 63 85 62 82 67 77 111 67 66 54 105 62 75 69 68 55 69 62 81 49 79 67 77 88 81 95 64 96 81 73 86 69 85 99 79 69 88 95 65 108 77 67 48 84 82 77 81 75 64 88 80 70 77 80 82 44 111 92 83 90 95 76 66 66 72 75 58 84 85 81 40 55 90 62 57 83 73 83 88 79 69 66 83 84 59 88 81 71 83 75 95 74 78 94 52 32 77 84 51 86 70 69 83 92 81 64 97 94 87 70 69 63 49 42 111 91 84 28 89 48 117 71 72 82 34 100 95 86 62 85 71 89 59 68 89 97 66 78 61 79 74 70 54 63 76 78 72 102 76 67 82 119 102 110 75 92 73 69 134 64 70 91 84 75 68 58 51 104 89 107 101 16 108 75 84 74 86 92 61 70 69 82 85 72 89 72 81 47 97 87 72 88 64 55 77 88 115 82 66 99 84 72 87 88 62 103 67 33 76 84 64 57 75 63 69 91 53 96 98 80 108 69 96 94 72 54 103 86 93 85 90 81 85 74 99 84 86 106 85 83 71 88 108 75 104 70 64 66 95 88 66 96 16 77 73 73 85 106 92 49 35 113 64 96 106 95 79 99 56 93 81 117 100 68 70 121 55 93 85 90 85 74 26 91 112 66 69 78 64 79 121 65 48 67 68 67 77 77 72 99 84 118 104 58 87 80 76 114 72 30 81 89 69 71 73 65 96 120 88 86 49 74 72 50 105 64 69 66 88 94 95 94 89 105 113 74 52 62 64 85 102 104 83 60 52 102 75 94 65 96 123 27 91 52 75 77 100 62 74 99 90 106 100 67 47 99 88 80 65 97 97 63 67 75 107 63 91 87 64 85 76 100 27 49 85 96 73 89 93 88 93 78 81 76 99 76 102 81 73 74 96 82 93 65 131 57 68 66 92 65 88 81 73 79 74 103 65 81 118 66 84 87 60 74 94 99 81 90 82 91 84 101 84 49 72 103 91 53 79 55 92 73 84 85 90 109 65 74 105 78 56 81 59 79 67 84 73 123 92 80 38 70 78 78 87 74 83 91 102 139 62 66 81 91 88 93 100 67 83 71 81 78 79 95 82 81 62 91 72 91 66 66 87 100 52 63 65 82 91 67 100 53 69 111 72 95 75 107 107 62 61 91 89 69 74 76 83 105 61 82 89 48 97 74 105 46 82 65 96 78 53 78 72 80 71 85 73 53 55 57 68 73 83 46 90 87 79 88 80 52 89 110 124 86 68 40 79 58 97 74 80 89 102 61 43 95 79 147 65 107 95 81 84 102 76 68 95 70 42 84 37 46 74 78 89 86 82 80 70 108 53 80 101 58 81 104 62 95 102 73 63 111 76 64 78 99 66 88 86 91 94 66 50 109 98 79 62 62 85 76 56 81 85 90 84 73 78 91 78 79 94 78 72 85 69 80 89 93 78 81 61 54 73 57 95 68 60 77 68 103 84 86 58 101 87 81 89 83 31 115 79 90 78 86 106 99 99 94 54 109 112 69 108 67 71 117 47 89 84 77 93 52 82 100 91 92 71 83 78 41 71 77 89 87 73 63 75 61 69 70 79 82 92 75 68 74 69 102 74 50 55 69 116 98 68 96 61 101 90 73 87 55 86 91 103 89 102 65 77 118 93 112 93 90 96 86 107 42 63 92 80 91 77 154 82 81 69 79 79 95 70 72 71 80 56 67 69 89 92 87 111 116 95 52 49 72 114 57 82 92 84 71 71 75 82 68 63 91 82 82 73 115 83 59 15 69 71 89 71 65 96 70 93 87 78 81 65 99 141 107 112 56 103 93 71 73 115 58 115 88 53 68 101 79 90 62 102 97 61 39 66 89 74 86 83 68 45 97 84 88 147 77 91 39 76 73 50 146 59 93 101 90 78 105 84 98 79 99 57 61 61 73 107 103 41 79 69 67 69 86 73 113 76 77 82 93 120 59 73 103 142 78 84 97 85 74 106 68 63 66 37 59 98 78 70 109 71 81 78 86 91 68 80 62 83 87 70 92 77 68 54 61 126 40 62 75 63 89 104 43 81 66 106 71 91 93 90 99 89 98 89 86 88 95 115 86 105 62 66 101 68 117 45 52 86 110 90 68 71 64 86 83 84 54 89 96 112 89 83 82 100 18 86 89 72 98 89 73 66 92 84 65 67 91 70 83 77 67 71 109 79 80 88 82 73 41 94 88 47 93 101 104 159 75 78 73 99 90 78 84 115 90 67 112 46 78 77 97 105 104 37 77 79 106 80 54 89 52 60 91 89 83 102 72 90 103 62 126 62 83 69 50 90 114 81 71 71 102 101 92 90 97 92 63 107 84 72 71 64 69 91 69 93 87 86 72 105 86 64 62 115 71 62 73 107 53 96 78 78 42 48 62 62 79 149 131 75 117 84 71 85 68 68 76 72 124 82 85 91 102 66 66 119 104 89 90 136 90 62 93 69 29 70 90 72 93 56 73 99 70 82 81 73 79 65 81 52 59 74 94 68 99 98 71 121 91 61 68 88 74 54 71 79 68 76 105 90 87 110 86 66 95 84 76 94 78 98 116 87 92 85 69 91 72 76 89 96 67 77 76 70 85 107 91 84 101 96 65 105 93 91 71 57 132 53 89 78 85 87 84 75 80 90 75 71 101 80 94 61 70 78 87 96 98 78 93 90 137 76 100 97 69 101 99 76 71 67 103 82 72 98 67 78 72 78 40 68 91 64 73 73 78 70 63 43 90 64 90 105 96 67 102 81 87 54 75 74 132 73 105 36 77 75 99 144 95 84 72 83 61 71 79 87 69 94 82 65 72 76 78 82 128 91 104 74 95 76 89 107 75 76 71 64 75 86 89 48 68 105 90 75 90 100 65 74 98 92 90 79 90 107 59 86 111 85 101 63 89 90 94 84 78 35 39 87 95 100 82 101 76 102 72 73 101 102 88 89 75 108 57 59 52 103 87 80 65 65 63 82 73 95 21 74 65 79 79 68 86 93 90 86 92 92 71 89 81 79 91 73 98 104 81 81 117 98 99 101 95 64 119 106 94 73 65 95 95 82 50 98 88 65 110 115 80 77 92 72 78 113 118 103 99 99 80 113 92 80 43 81 122 91 74 73 63 70 85 84 71 95 92 90 114 115 86 87 95 78 57 53 73 81 111 82 68 66 75 94 76 68 81 82 44 85 103 74 90 66 72 35 20 97 78 58 38 147 72 85 68 87 38 90 100 83 129 62 91 89 89 69 70 117 83 59 58 49 73 42 86 93 65 109 90 82 100 94 76 74 58 59 83 51 50 92 55 100 96 81 81 80 107 73 92 70 66 71 68 87 79 66 76 64 66 86 69 109 26 77 97 71 75 98 69 88 98 110 102 83 93 73 66 75 57 57 106 65 93 91 62 61 82 95 74 72 92 78 100 84 75 74 47 89 76 83 54 65 78 91 90 62 56 39 85 68 73 89 73 69 91 17 79 92 105 28 85 92 61 64 50 77 86 87 74 90 52 60 85 83 102 59 89 51 93 128 94 89 104 112 104 91 79 89 73 72 88 78 105 81 72 70 63 103 92 92 91 77 69 52 88 106 89 84 78 52 74 55 79 80 101 123 78 54 128 81 86 62 115 104 77 78 80 70 94 142 59 101 46 99 59 97 72 96 84 68 63 60 68 68 46 76 88 52 87 78 108 67 82 82 100 60 72 97 52 103 68 86 95 52 76 142 59 65 115 78 89 89 95 95 104 62 99 116 83 83 79 93 76 64 90 70 80 78 38 97 84 45 141 83 78 28 73 89 74 73 49 73 97 86 88 82 85 91 112 81 86 87 77 77 76 62 38 85 109 100 84 80 78 84 64 100 95 61 42 67 61 62 84 111 92 106 99 105 109 82 21 89 99 81 54 71 63 92 86 60 80 66 80 93 99 59 78 70 79 68 73 110 98 97 74 93 57 83 78 74 120 39 92 37 79 80 110 64 96 65 65 62 60 106 100 104 102 89 69 78 60 70 77 103 104 74 62 70 71 107 87 69 70 97 76 44 67 98 66 73 103 76 89 91 71 81 57 74 50 101 75 132 74 93 85 112 79 79 62 57 96 81 89 78 87 46 89 72 85 44 86 74 95 80 91 98 90 62 55 116 73 43 75 79 70 85 79 97 88 68 126 114 99 96 76 89 62 94 68 40 47 83 60 87 97 56 76 57 60 71 112 55 46 61 73 100 87 60 125 91 74 76 65 62 38 87 90 105 73 84 63 80 97 88 66 79 68 136 72 86 95 65 95 52 93 81 56 114 50 66 94 71 83 82 66 109 94 107 68 66 61 95 82 99 104 88 80 68 79 86 88 85 83 71 105 93 56 79 88 67 94 29 91 82 61 52 79 87 61 79 113 102 100 61 109 82 74 98 101 45 74 87 92 90 109 76 62 81 77 85 66 91 97 68 112 76 79 93 89 77 124 78 93 84 84 79 90 60 93 98 75 99 113 94 80 57 85 79 75 96 96 113 80 86 80 86 58 68 72 99 72 51 67 38 51 78 48 76 75 112 45 110 88 41 82 97 44 93 76 89 75 132 87 69 77 73 76 86 78 70 83 70 79 85 77 84 68 74 46 95 76 112 123 80 76 70 96 95 78 83 78 78 55 95 92 94 81 84 82 104 81 83 91 78 71 84 124 121 81 86 79 72 76 65 72 71 75 107 96 71 90 55 61 67 58 71 59 63 90 64 78 78 87 90 83 91 77 30 82 61 123 62 97 91 73 89 80 61 45 79 89 63 74 81 115 64 71 59 68 36 61 93 73 79 99 52 81 64 66 89 69 76 73 74 97 102 71 83 85 112 125 68 78 97 31 81 45 76 83 65 91 76 74 54 75 83 85 71 79 106 79 98 75 86 45 83 71 61 38 88 87 93 55 91 108 81 70 81 83 80 100 86 88 104 70 50 74 104 68 65 71 32 55 76 53 89 81 58 75 91 71 99 87 57 67 98 78 99 85 84 87 81 84 97 49 85 98 79 101 37 78 102 109 61 78 66 86 98 77 84 66 82 69 62 118 79 71 103 82 68 93 78 64 63 94 96 62 54 79 86 107 75 93 62 75 73 88 127 63 61 77 83 78 90 49 79 76 78 70 77 109 85 100 88 78 72 77 67 100 94 96 82 78 75 90 79 79 64 69 56 88 98 102 78 94 99 71 83 102 67 82 82 88 101 72 76 65 89 99 70 90 101 76 93 78 86 106 91 112 72 75 63 74 48 74 82 85 67 77 113 65 68 97 107 44 111 72 73 70 120 112 98 94 84 72 89 100 81 72 93 91 88 68 51 83 63 107 78 62 95 34 97 91 84 68 45 89 72 62 101 71 83 26 62 86 90 66 98 71 85 63 105 93 106 55 39 76 92 72 78 118 81 85 95 77 82 83 86 99 98 66 107 101 93 77 74 97 66 71 90 87 102 95 75 77 45 82 77 54 72 78 86 89 149 88 81 97 123 73 64 104 78 56 59 104 84 62 83 98 69 91 91 88 104 80 93 88 103 59 84 105 91 137 52 101 107 86 85 86 95 59 130 97 78 69 64 81 93 97 74 82 81 92 69 73 43 64 98 52 69 75 109 86 79 133 79 58 69 120 49 34 69 95 107 79 70 90 110 103 87 55 69 83 93 81 72 88 61 105 90 74 70 94 67 84 94 60 26 111 74 80 99 48 81 71 91 88 82 94 95 74 66 128 73 92 55 80 86 84 61 48 67 82 83 89 84 90 91 80 106 86 75 124 73 55 77 68 123 70 88 108 95 74 19 85 106 86 96 68 90 21 84 90 75 85 77 84 24 64 74 86 72 83 109 75 99 93 83 91 85 72 52 76 77 64 54 68 94 70 76 70 110 116 78 70 55 61 54 72 48 90 52 78 77 92 119 104 49 99 78 66 69 91 80 67 83 94 86 104 85 85 78 61 67 83 73 79 90 88 90 89 87 87 73 78 84 59 84 78 68 41 100 100 73 98 73 85 128 90 82 83 129 74 96 91 113 100 97 71 84 72 105 44 85 70 59 103 70 84 75 123 59 73 78 69 50 71 80 54 105 111 42 57 94 84 80 134 27 89 69 96 59 69 70 56 103 96 102 87 89 80 130 70 60 97 87 79 76 99 75 81 90 77 109 113 78 93 91 96 90 73 59 76 100 114 45 97 62 50 62 74 75 88 57 79 84 86 99 104 105 104 83 65 81 80 88 81 103 56 81 79 63 99 61 75 85 83 65 78 61 70 91 96 78 87 89 112 64 86 82 97 63 90 83 71 85 77 99 101 106 84 95 69 89 95 86 67 67 92 85 102 77 89 95 70 119 78 89 74 102 82 75 52 130 32 59 128 76 73 81 29 66 78 79 66 76 90 87 80 82 91 77 90 102 69 74 66 79 115 50 59 83 65 81 77 79 86 48 163 77 77 106 71 57 82 78 106 75 74 70 116 66 109 72 107 84 81 82 64 91 73 73 96 77 65 77 70 97 83 97 64 78 79 63 106 70 90 74 59 66 92 75 68 76 95 93 89 97 77 108 75 82 106 56 65 88 76 92 79 58 125 70 100 79 74 72 83 75 75 63 97 107 95 100 69 96 80 89 51 108 86 111 76 88 86 95 65 62 82 54 68 79 63 101 77 149 82 65 88 95 103 93 69 95 62 84 72 45 73 110 58 54 82 115 86 89 83 90 135 80 87 84 91 47 123 80 74 77 67 75 101 70 100 65 78 139 79 74 73 88 85 111 70 78 59 84 84 72 106 41 45 94 82 110 65 91 77 77 127 90 90 73 85 84 86 66 64 129 95 90 73 86 50 81 71 78 102 60 90 89 80 84 90 68 75 99 74 84 85 74 94 95 78 86 87 61 72 76 110 77 78 86 99 84 83 94 61 81 70 69 72 86 97 100 82 125 99 85 97 62 66 85 47 87 75 69 75 95 82 70 87 71 90 26 92 82 82 79 102 63 67 93 41 72 72 81 87 80 62 113 111 89 54 61 78 76 84 86 100 73 83 72 89 28 89 78 71 79 43 73 80 89 81 104 90 127 86 71 61 91 104 81 87 65 121 70 75 78 67 49 111 81 105 71 100 69 86 47 75 93 64 79 80 77 83 78 83 55 57 99 95 31 69 71 79 92 51 73 85 53 101 71 80 74 76 52 74 87 91 116 100 101 104 121 92 57 81 75 59 104 106 86 91 59 75 97 78 102 78 111 85 63 87 126 81 81 59 77 67 91 79 76 78 72 87 52 72 125 85 89 73 89 87 83 55 75 67 65 64 109 103 32 71 125 77 102 96 81 90 45 94 72 76 32 59 88 89 73 79 70 105 89 58 82 97 78 88 94 111 62 85 81 101 91 100 106 67 73 118 69 82 77 67 78 88 127 87 106 100 74 149 103 57 51 72 70 61 62 77 84 91 90 87 79 47 77 56 75 73 69 59 52 104 85 36 68 52 77 81 88 95 72 114 94 50 80 71 87 80 60 67 68 98 74 83 67 92 63 56 58 39 89 125 88 90 76 73 73 99 79 72 71 76 109 88 67 87 98 70 50 95 88 71 65 63 76 115 67 66 88 69 85 103 68 62 99 89 91 107 2 96 72 110 84 63 72 49 118 98 105 70 88 107 83 90 103 92 65 84 69 70 56 57 90 105 71 36 58 70 85 62 69 94 79 75 83 94 86 79 76 69 78 73 93 93 55 71 55 62 123 71 97 102 56 73 96 82 60 143 86 85 86 101 50 94 77 96 140 89 89 98 78 126 84 107 60 89 99 87 70 81 77 75 101 93 67 73 91 79 93 51 74 105 111 108 84 81 127 77 87 65 61 65 101 70 86 93 84 85 74 80 85 118 73 66 83 106 91 84 83 52 96 60 84 63 64 78 43 80 92 76 88 106 75 89 103 93 79 88 103 94 89 82 78 97 121 67 53 80 74 74 80 61 61 90 82 94 85 50 75 103 106 69 68 96 91 60 98 76 55 89 58 63 104 73 82 77 76 87 81 70 67 46 81 64 70 34 116 60 84 76 81 79 91 93 45 111 78 72 66 68 76 81 54 88 79 71 62 97 74 47 100 113 81 74 77 73 86 94 69 112 57 121 93 74 110 62 110 48 103 89 86 82 96 54 100 84 69 72 105 47 112 44 38 86 79 92 109 89 122 73 70 82 67 91 88 82 95 90 74 92 87 70 70 79 80 71 78 79 42 57 94 70 66 116 94 107 92 66 82 81 66 70 74 96 122 75 79 75 124 91 124 82 87 74 127 87 90 63 55 86 57 107 126 83 127 77 102 66 80 87 85 71 64 74 77 122 79 76 64 116 106 55 36 93 87 92 65 62 105 84 99 69 78 72 93 83 73 89 97 70 89 76 95 76 79 76 79 83 72 78 67 87 28 86 86 64 82 123 66 98 86 81 95 78 99 92 48 94 75 88 76 83 90 107 68 56 80 92 82 92 118 78 69 45 83 70 82 89 83 61 68 90 101 91 93 73 91 97 87 65 80 68 85 84 101 101 71 70 132 71 101 84 71 37 115 75 96 81 92 85 62 76 77 102 73 63 58 52 82 105 72 76 88 75 53 59 71 100 80 96 87 87 90 62 71 79 109 47 56 102 75 42 97 74 89 80 113 85 114 47 85 71 83 96 106 100 106 82 74 85 54 82 61 78 101 70 83 58 81 91 110 66 82 58 98 79 89 108 86 96 71 82 123 115 107 92 65 119 88 75 81 72 90 107 90 107 53 89 95 65 113 83 94 94 68 79 106 42 77 88 89 94 70 76 71 74 83 73 77 85 74 80 90 94 81 57 78 81 73 108 67 94 92 92 71 87 59 61 100 82 58 95 78 78 77 63 75 74 43 72 68 66 82 56 92 63 76 58 78 92 88 85 71 93 82 71 75 65 77 76 75 78 59 100 142 44 35 91 61 61 68 102 76 69 77 64 52 85 110 112 51 81 96 81 109 118 58 110 63 68 32 106 79 53 79 98 69 74 40 73 100 80 71 75 87 79 98 88 76 93 92 97 50 99 70 44 88 94 86 104 97 55 79 79 73 73 85 73 99 90 87 92 83 109 96 51 75 77 79 98 89 73 54 95 85 57 77 70 75 73 60 107 51 53 87 106 100 55 57 70 69 83 63 82 54 90 63 56 81 88 112 121 112 88 97 68 72 86 112 70 91 96 80 67 89 54 82 98 55 63 54 93 57 83 100 99 106 94 48 97 88 70 102 30 84 89 104 84 63 74 81 86 81 89 56 85 61 34 101 110 83 69 96 85 79 104 96 77 87 71 83 83 83 64 75 88 72 95 70 91 84 86 82 86 122 73 86 75 82 71 69 86 94 71 78 81 70 75 88 97 89 80 93 80 95 95 98 73 63 64 78 82 101 88 59 61 110 84 106 79 113 59 104 56 77 91 90 93 62 70 68 46 129 85 86 83 61 104 60 54 51 90 56 91 64 106 99 84 65 62 76 55 69 66 94 142 71 57 102 67 51 78 47 68 99 71 80 75 82 25 150 65 85 112 70 72 140 78 81 91 91 95 83 81 68 86 93 75 72 86 125 41 75 88 132 77 99 83 69 82 75 59 91 72 74 100 98 60 77 85 109 83 91 91 96 55 116 87 90 108 65 97 119 81 71 102 89 93 91 77 75 59 70 113 90 93 108 70 62 80 93 73 63 56 86 114 84 63 72 54 89 102 116 74 73 119 81 111 80 78 58 97 86 53 92 88 107 95 118 50 58 69 80 87 80 82 85 77 13 71 39 96 87 102 101 77 80 64 67 60 20 98 72 90 62 67 87 83 86 82 69 68 103 96 81 76 155 86 47 99 93 92 62 87 85 88 60 71 70 108 80 104 72 76 71 67 88 95 72 40 79 77 97 93 74 85 102 86 93 70 55 86 97 36 80 89 86 65 65 104 83 79 87 91 103 102 103 88 65 89 67 86 100 94 16 77 67 73 69 63 83 48 53 116 65 128 83 87 51 81 82 101 45 98 48 86 86 72 132 69 86 61 99 74 66 64 24 46 118 106 61 102 72 89 67 81 74 95 95 96 62 87 64 77 83 131 89 98 80 80 107 77 106 71 86 73 103 99 80 78 81 79 112 108 50 54 67 88 62 123 87 73 69 71 58 108 89 104 66 93 91 78 45 72 75 90 100 95 70 57 96 86 60 97 83 96 115 107 68 48 81 92 126 68 104 65 81 78 108 86 106 85 45 71 77 91 77 94 80 88 67 74 108 90 103 42 95 87 90 105 91 56 97 78 76 90 68 67 72 69 90 86 55 104 92 79 72 107 68 86 84 76 63 125 80 70 74 61 73 75 76 75 99 108 60 74 89 80 74 60 62 62 95 43 95 26 60 86 107 59 79 65 76 62 69 109 80 84 78 94 93 60 92 111 85 80 68 102 84 76 63 99 50 78 80 64 62 97 74 79 118 106 95 97 72 47 93 70 86 94 88 96 89 72 131 68 86 75 111 100 71 76 89 59 88 60 81 57 85 73 62 76 74 66 87 126 85 65 69 104 99 53 110 93 70 113 81 77 97 56 90 47 87 86 89 97 108 62 59 82 113 94 110 95 95 77 121 89 66 72 75 70 79 78 66 77 86 85 101 58 56 64 108 105 73 72 95 75 92 92 82 69 54 80 33 59 75 88 77 98 104 110 80 83 80 78 65 80 74 86 77 72 81 87 79 65 99 97 95 102 90 125 109 29 74 112 69 87 80 54 63 85 98 86 72 105 82 74 75 93 83 52 93 67 145 77 110 71 93 85 82 64 95 69 73 84 96 76 73 94 81 79 79 75 75 98 99 46 75 65 61 96 68 120 98 68 82 118 72 59 67 75 71 66 89 87 52 65 84 96 44 35 57 84 85 84 71 79 78 77 132 76 91 83 127 81 67 101 75 57 67 99 40 83 82 40 85 85 90 69 86 100 93 87 108 77 83 63 46 108 93 72 78 118 68 60 82 79 107 89 75 100 24 102 93 95 54 90 69 83 109 109 123 88 84 38 98 75 68 96 70 94 112 94 77 98 65 132 75 88 63 80 87 92 97 88 88 63 105 79 98 87 101 60 78 99 57 92 86 44 51 37 91 92 78 90 116 92 74 69 98 148 114 103 77 51 101 127 118 77 105 94 76 67 93 73 86 99 92 106 90 75 96 88 72 69 43 75 101 118 73 49 100 78 76 58 95 106 85 100 83 76 99 67 80 60 78 102 66 68 87 66 89 33 80 65 86 67 86 93 82 69 100 98 100 90 87 88 86 107 106 74 76 64 84 94 96 120 85 25 94 69 73 77 69 80 86 89 66 99 94 101 85 34 58 79 52 105 85 52 63 92 87 13 72 71 82 83 86 79 81 79 82 77 107 95 82 115 64 84 61 79 88 86 56 43 81 116 82 82 91 67 94 72 60 97 84 61 93 95 64 84 57 110 75 60 96 62 87 81 97 77 46 73 88 94 80 75 71 93 140 83 72 103 65 72 70 91 90 90 87 74 76 88 100 69 58 89 87 92 70 119 64 111 60 70 95 72 82 60 61 93 88 89 77 75 79 90 83 80 121 83 57 99 55 53 42 67 110 106 71 95 109 58 68 78 91 91 82 105 67 76 78 92 72 59 82 56 72 74 31 71 95 77 74 81 79 74 56 85 43 74 99 111 92 123 61 18 70 110 107 98 80 91 85 60 59 70 73 79 63 63 62 102 76 85 90 80 65 81 72 58 100 84 80 76 80 70 87 43 84 94 80 131 60 68 68 92 118 58 84 89 77 107 77 66 77 86 102 73 64 150 44 43 100 73 78 55 94 76 79 91 70 79 70 107 116 69 67 80 58 79 92 38 76 29 75 69 52 59 100 92 60 83 72 101 75 109 97 83 97 85 150 96 94 93 86 11 39 35 73 106 84 95 91 74 78 87 64 47 85 98 68 61 67 87 149 69 85 88 90 44 76 96 82 87 76 87 87 56 91 98 72 70 79 57 78 74 108 115 135 61 98 91 75 53 70 80 77 79 94 38 89 105 73 80 76 87 103 65 116 99 74 76 67 81 109 90 77 72 104 77 67 86 122 74 93 67 57 98 86 75 69 76 83 113 87 82 65 80 96 85 72 114 77 29 77 58 94 70 63 74 81 86 95 80 72 66 78 94 119 85 45 48 89 94 70 82 82 87 68 100 99 91 86 90 53 61 64 47 98 92 97 71 60 65 70 90 94 73 115 66 148 95 78 72 113 77 96 105 50 89 95 101 69 81 79 86 71 80 62 78 114 88 101 78 56 66 63 53 63 70 65 103 82 68 72 94 95 105 85 103 76 64 81 82 69 91 73 81 114 80 100 77 73 120 78 78 70 91 73 89 83 119 75 86 57 89 68 75 76 62 86 82 79 51 52 81 67 85 77 72 65 92 66 83 80 88 66 84 79 67 82 83 75 84 91 105 94 53 116 89 84 75 97 77 92 87 94 76 87 90 66 77 78 76 96 67 79 90 103 78 68 84 83 107 81 75 75 99 68 36 74 107 84 59 2 72 69 88 74 80 89 108 72 74 84 110 59 53 114 72 68 96 52 141 97 91 64 96 84 62 67 84 56 90 84 83 74 84 78 115 102 77 61 101 101 76 36 84 86 68 92 71 79 98 107 51 46 76 94 105 99 91 84 84 93 73 102 75 72 64 91 75 95 73 63 60 76 44 36 81 113 56 64 73 102 68 102 101 70 81 91 48 95 91 44 89 66 35 72 54 91 44 89 45 110 61 101 117 113 59 56 65 90 72 75 81 79 90 80 108 79 75 67 89 111 62 108 127 95 76 61 90 85 68 97 69 67 75 70 53 40 73 110 112 73 93 53 80 84 75 89 109 72 98 68 88 81 115 77 99 49 97 43 112 73 64 107 76 121 63 91 76 73 93 97 66 38 99 86 64 61 81 85 92 87 91 89 104 81 88 79 67 42 90 108 90 74 102 120 67 66 85 96 86 101 105 78 56 93 92 73 52 64 86 78 69 71 59 85 80 79 93 94 59 90 74 53 88 33 66 103 107 71 76 92 90 92 109 102 75 42 89 33 103 63 115 81 102 88 87 48 70 83 88 76 69 87 97 93 100 64 89 61 85 81 53 71 96 92 87 73 84 93 106 55 62 114 72 100 67 83 123 56 76 67 83 81 97 75 76 95 92 123 90 80 87 86 59 77 73 81 85 83 99 68 100 65 102 67 39 95 88 118 85 33 104 100 80 99 56 81 91 91 66 83 97 65 96 74 75 102 73 83 135 57 83 98 102 66 56 103 56 62 171 85 63 57 85 89 97 73 70 46 64 77 85 99 91 82 110 79 94 61 60 89 55 72 77 95 98 81 57 64 63 56 70 42 55 91 91 85 62 82 95 61 78 87 96 93 78 109 56 68 90 80 81 97 90 87 89 129 92 85 46 69 58 84 71 72 73 94 91 82 104 116 105 108 73 101 101 112 102 85 86 55 82 69 82 52 90 98 66 87 100 59 76 64 84 89 38 111 129 112 64 67 95 99 67 92 79 89 68 70 73 88 87 76 91 113 106 65 105 70 119 81 101 61 96 92 103 77 75 72 86 81 83 112 112 48 87 103 120 18 85 78 105 41 47 69 67 82 68 67 82 88 70 76 89 72 80 40 90 86 90 128 84 80 67 109 94 79 97 94 77 81 53 104 81 94 85 69 61 121 126 90 42 55 56 64 93 105 99 82 84 49 112 85 74 89 71 88 127 82 84 94 44 59 108 89 88 109 70 69 67 86 80 71 83 78 108 112 66 72 81 93 54 61 111 45 80 73 56 74 58 73 74 89 77 70 64 116 55 93 60 106 91 103 61 93 102 100 49 65 90 112 61 77 102 92 67 83 111 85 94 69 89 86 82 93 80 58 83 74 77 100 71 92 89 118 77 88 49 61 84 87 106 51 97 92 131 103 91 99 35 100 73 98 91 71 87 74 86 76 88 74 82 101 75 30 107 113 73 67 76 64 31 81 129 41 81 98 80 153 71 85 69 73 69 91 56 96 83 61 66 66 65 74 82 80 113 78 102 64 87 100 84 92 71 118 75 78 66 79 107 63 90 65 71 81 104 82 68 112 101 90 88 100 72 92 78 40 96 73 66 56 73 65 82 88 108 82 82 81 87 96 88 89 97 72 83 68 92 58 94 72 87 106 91 102 64 34 81 98 77 74 45 52 46 83 53 59 60 100 65 80 84 98 79 105 64 85 101 76 50 59 99 64 63 95 59 102 84 73 107 60 101 115 51 94 90 113 85 116 101 81 102 66 79 74 96 102 75 121 55 76 62 54 76 89 81 71 85 58 66 96 33 52 75 96 96 46 96 81 73 99 77 90 63 74 94 82 88 94 95 93 131 67 59 61 78 78 96 60 93 106 85 80 83 89 105 107 82 104 66 105 88 40 42 82 85 91 62 65 68 88 90 98 80 117 90 102 64 94 55 72 72 67 59 85 92 83 67 89 88 78 79 61 100 113 75 23 87 92 78 65 72 62 87 87 80 89 95 91 97 54 82 115 79 99 81 104 66 96 109 74 76 74 100 78 119 74 55 86 92 59 80 51 38 85 87 59 74 84 50 79 82 67 84 120 116 93 86 86 74 65 71 136 90 63 95 77 82 86 103 94 84 84 72 117 55 69 57 80 76 73 50 31 96 87 92 75 112 42 109 75 92 85 80 76 76 100 54 75 110 72 119 82 53 98 57 111 98 70 118 101 81 107 55 125 87 117 74 87 72 65 98 51 156 83 67 52 80 89 99 84 64 108 77 107 94 100 92 94 95 83 91 121 103 65 47 77 48 63 104 117 62 62 79 110 68 87 74 56 38 90 91 45 84 75 88 73 96 94 79 117 43 62 93 92 91 88 64 79 54 85 43 125 90 75 108 72 98 79 61 106 117 73 97 84 106 79 62 110 94 98 80 84 85 108 10 109 62 99 69 76 98 95 97 75 65 79 106 98 82 93 96 116 70 84 75 67 83 69 72 136 66 74 97 181 75 95 73 101 91 105 85 121 98 91 61 93 96 72 76 95 63 82 70 137 97 84 93 88 54 69 96 65 85 93 66 70 92 79 38 113 118 91 87 64 80 66 52 100 79 78 71 114 105 89 88 72 96 79 95 78 68 114 65 82 92 83 84 100 97 102 74 78 96 73 90 97 84 95 73 119 88 98 77 52 103 136 64 92 76 96 66 78 68 78 84 75 104 86 84 93 68 78 53 100 70 93 65 72 85 73 33 125 67 45 67 113 52 81 94 82 75 94 63 98 75 85 49 71 55 70 82 95 84 29 110 87 73 86 69 72 70 85 72 79 109 63 74 55 146 71 78 128 35 83 59 106 102 83 87 49 74 78 75 86 74 66 110 111 122 91 88 87 52 98 89 67 80 87 50 80 90 95 111 85 74 86 114 89 94 82 84 70 98 95 94 35 91 113 72 82 101 78 76 53 88 92 118 81 135 87 65 98 116 66 79 90 86 66 111 83 150 88 83 97 74 77 88 49 109 121 118 63 63 87 52 103 91 54 103 79 59 82 93 80 52 104 72 69 100 95 92 100 80 89 82 103 94 80 83 75 89 117 55 91 65 100 91 82 87 111 60 86 93 54 144 84 84 65 105 79 53 92 119 76 88 52 52 99 106 122 116 60 80 114 67 121 87 63 118 81 67 83 82 107 61 76 49 63 73 90 66 104 96 78 76 94 44 65 96 125 97 78 77 98 85 31 82 88 64 80 92 76 91 89 70 81 95 130 81 90 76 102 70 114 81 77 75 63 63 75 96 80 93 115 60 59 80 96 64 92 89 70 69 76 104 71 74 79 81 87 78 57 92 91 64 58 92 47 65 76 98 57 75 74 78 78 92 52 88 53 50 82 106 57 75 73 99 81 68 65 107 100 81 69 51 72 96 124 71 82 59 75 46 76 104 57 62 83 64 79 60 79 64 70 106 93 85 73 86 109 71 40 79 51 72 123 96 87 95 103 90 80 52 125 101 78 88 92 67 91 102 71 40 53 112 94 76 82 68 83 89 64 93 85 121 59 85 96 106 38 93 79 84 88 108 82 126 88 71 59 62 70 73 92 89 66 60 64 67 91 40 97 69 110 89 81 76 53 83 74 72 43 81 85 99 110 82 88 65 68 69 90 67 57 72 81 73 58 95 84 66 105 81 72 63 94 113 130 99 97 97 72 94 80 91 89 84 54 89 80 111 84 78 72 80 72 80 108 107 96 88 62 90 70 56 79 63 90 63 66 93 91 54 74 88 76 80 73 94 84 95 99 100 77 112 92 74 71 83 90 54 73 76 75 86 90 62 80 44 82 102 109 84 65 74 77 76 39 77 75 67 70 92 80 71 64 79 101 71 87 90 38 73 87 79 73 102 106 77 88 70 105 71 88 70 49 56 42 86 85 75 87 73 78 81 69 116 60 90 88 103 90 95 100 96 104 132 63 47 70 100 83 79 81 91 46 103 78 71 76 92 79 86 83 91 97 95 74 50 80 111 76 110 65 60 99 45 81 98 84 70 115 79 84 49 54 90 88 98 60 85 92 86 88 74 85 85 27 59 78 75 86 67 58 94 80 72 73 75 106 96 85 103 31 101 86 45 88 88 80 70 54 72 94 107 84 47 61 89 123 92 85 74 92 85 87 75 118 76 116 86 74 88 91 65 94 72 77 99 102 80 93 82 84 103 62 111 77 99 96 85 79 43 87 65 67 75 79 78 105 91 99 75 126 79 93 63 86 87 95 78 87 98 83".split(" ");
		FileWriter fw=null;
		BufferedWriter bw=null;
		fw = new FileWriter(new File("out.txt"));
		bw = new BufferedWriter(fw);
		try (Scanner s = new Scanner(System.in)) {
			int n = s.nextInt();
			int m = s.nextInt();
			m=999200;
			ArrayList<ArrayList<Vertex>> adjList = new ArrayList<ArrayList<Vertex>>(n + 1);
			for (int i = 0; i <= n; i++) {
				adjList.add(i, new ArrayList<Vertex>());
			}
			for (int i = 1; i <= m; i++) {
				int u = s.nextInt();
				int v = s.nextInt();
				int cost = s.nextInt();
				adjList.get(u).add(new Vertex(v, cost));
			}
			int max = 1000000000;
			MinHeap queue = new MinHeap(n);
			queue.add(new Vertex(1, 0));
			for (int i = 2; i <= n; i++) {
				
				queue.add(new Vertex(i, max));
			}
			int distance[] = new int[n + 1];
			Arrays.fill(distance, max);
			while (!queue.isEmpty()) {
				//System.out.println(distance[5928]);
				//bw.append(distance[2]+" ");
				Vertex current = queue.remove();
				
				if (current.getPriority() == max) {
					break;
				} else {
					distance[current.getId()] = current.getPriority();
					bw.append(current.getId()+" "+distance[current.getId()]+" "+expected[current.getId()]+"\n");
					bw.flush();
					for (Vertex neighbour : adjList.get(current.getId())) {
						if (distance[neighbour.getId()] > distance[current.getId()] + neighbour.getPriority()) {
							queue.update(neighbour, distance[current.getId()] + neighbour.getPriority());
						}
					}
				}
			}
			
			for (int i = 2; i <= n; i++) {
				//System.out.print(distance[i] + " ");
				
				
				//bw.append(distance[i]+" ");
				bw.flush();
				
			}
			//bw.append(distance[2]+" ");
			bw.flush();
			bw.close();
			fw.close();
			
		}
	}

	private static class Vertex implements Comparable<Vertex> {
		private int id;
		private int priority;

		public Vertex(int id, int priority) {
			super();
			this.id = id;
			this.priority = priority;
		}

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public int getPriority() {
			return priority;
		}

		public void setPriority(int priority) {
			this.priority = priority;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + id;
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Vertex other = (Vertex) obj;
			if (id != other.id)
				return false;
			return true;
		}

		@Override
		public int compareTo(Vertex o) {
			return priority - o.getPriority();
		}

	}

	private static class MinHeap {
		private Map<Vertex, Integer> indexMap = new HashMap<>();
		private int size;
		private Vertex[] heap;
		private int nextLocation;

		public MinHeap(int size) {
			this.size = size;
			heap = new Vertex[size];
		}

		public void add(Vertex v) {
			heap[nextLocation] = v;
			indexMap.put(v, nextLocation);
			nextLocation++;
			heapifyUp(nextLocation-1);
			
		}

		public void update(Vertex v, int newPriority) {
			int index = indexMap.get(v);
			heap[index].setPriority(newPriority);

			heapifyUp(index);
		}

		public Vertex remove() {
			nextLocation--;
			Vertex v = heap[0];
			if (nextLocation >=2) {				 
				Vertex last = heap[nextLocation];
				heap[0] = last;
				hepifyDown(0);
			}
			
			return v;
		}

		private void heapifyUp(int index) {
			int parent = getParent(index);
			while (parent != -1 && heap[parent].getPriority() > heap[index].getPriority()) {
				Vertex temParent = heap[parent];
				Vertex tempCurrent = heap[index];
				heap[parent] = tempCurrent;
				heap[index] = temParent;
				indexMap.put(temParent, index);
				indexMap.put(tempCurrent, parent);
				index = parent;
				parent = getParent(index);
			}
		}

		private void hepifyDown(int index) {
			int minIdx = getMinIndex(index);
			while (minIdx != index) {
				Vertex tempCurrent = heap[index];
				Vertex tempMin = heap[minIdx];
				heap[index] = tempMin;
				heap[minIdx] = tempCurrent;
				indexMap.put(tempCurrent, minIdx);
				indexMap.put(tempMin, index);
				index = minIdx;
				minIdx = getMinIndex(index);
			}
		}

		private int getMinIndex(int index) {
			int left = getLeft(index);
			int minIndex = index;
			if (left != -1) {
				if (heap[left].getPriority() < heap[minIndex].getPriority()) {
					minIndex = left;
				}
			}
			int right = getRight(index);
			if (right != -1) {
				if (heap[right].getPriority() < heap[minIndex].getPriority()) {
					minIndex = right;
				}
			}
			return minIndex;
		}

		private int getLeft(int index) {
			int left = (2 * index) + 1;
			if (left >= nextLocation) {
				return -1;
			}
			return left;
		}

		private int getRight(int index) {
			int right = (2 * index) + 2;
			if (right >= nextLocation) {
				return -1;
			}
			return right;
		}

		private int getParent(int i) {
			if (i == 0) {
				return -1;
			} else {
				return (i - 1) / 2;
			}
		}

		public boolean isEmpty() {
			if (nextLocation == 0) {
				return true;
			}
			return false;
		}
	}
}