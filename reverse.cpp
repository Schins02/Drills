#include <iostream>
#include <string>

using namespace std;

 //reversing a string in place
 string reverse(string str){
 	int length = str.length();
 	int i = 0;
	for(i = 0; i < length/2; i++){
		char c = str[i];
		str[i] = str[length - i - 1];
		str[length - i - 1] = c;
	}
		return str;
}

int main(){
	string str = "give me a job";
	str = reverse(str);
	cout << str +"\n";
	return 0;
}
