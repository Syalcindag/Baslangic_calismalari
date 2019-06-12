
#include<stdio.h>
#include<stdlib.h>
#include<conio.h>
#include<string.h>

 struct name{
	char authorname[25];
	 char bookname[25];
};
struct book{
	int row;
	struct name kayit[5];
};


FILE *myptr2;


int main(){
	struct book newbook[30];
	

	if((myptr2 = fopen("book.txt", "r")) == NULL){
		
		
		for(int i = 0 ; i < 30 ; i++){
			newbook[i].row = i+1;
			for(int j = 0; j < 5 ; j++){
			strcpy(newbook[i].kayit[j].authorname, "null");
			strcpy(newbook[i].kayit[j].bookname, "null");	
			}
		}
		
		if((myptr2 = fopen("book.txt","w")) == NULL){
			printf("dosya acýlamadý");
		}
		else{
				for(int i = 0 ; i < 30 ; i++){
			fprintf(myptr2, "%d %s %s %s %s %s %s %s %s %s %s\n", newbook[i].row,
			 newbook[i].kayit[0].bookname, newbook[i].kayit[0].authorname, 
			 newbook[i].kayit[1].bookname, newbook[i].kayit[1].authorname,
			newbook[i].kayit[2].bookname, newbook[i].kayit[2].authorname,
			newbook[i].kayit[3].bookname, newbook[i].kayit[3].authorname,
			newbook[i].kayit[4].bookname, newbook[i].kayit[4].authorname );
		}}
	}
	else{
		int i = 0;
		while(!feof(myptr2)){
		
		fscanf(myptr2, "%d %s %s %s %s %s %s %s %s %s %s\n", &newbook[i].row,
			 &newbook[i].kayit[0].bookname, &newbook[i].kayit[0].authorname, 
			 &newbook[i].kayit[1].bookname, &newbook[i].kayit[1].authorname,
			&newbook[i].kayit[2].bookname, &newbook[i].kayit[2].authorname,
			&newbook[i].kayit[3].bookname, &newbook[i].kayit[3].authorname,
			&newbook[i].kayit[4].bookname, &newbook[i].kayit[4].authorname )
			}
			i++;
			
		}
	
	fclose(myptr2);
	
	
	
	
	system("PAUSE");
	return 0;
}
