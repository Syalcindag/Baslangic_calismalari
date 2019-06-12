#include<stdio.h>
#include<stdlib.h>




struct book {
	int bookId;
	char bookName[25];
	char authorName[25];
};

FILE *myptr;


int main(){
	
	struct book newbook;
	struct book newbook2;
	int bookId ;
	char bookName[25];
	char authorName[25];
	
	printf("Enter the book id : ");
	scanf("%d", &bookId);
	printf("Enter the book name :");
	scanf(" %s", bookName);
	printf("Enter the author name :");
	scanf(" %s", authorName);
	
	
	newbook.bookId = bookId;
	
			for (int i = 0; i < 25; i++) {
				newbook.bookName[i] = bookName[i];
				}
	    	for (int i = 0; i < 25; i++) {
				newbook.authorName[i] = authorName[i];
				}
	
		
	if ((myptr = fopen("deneme.txt", "a+")) == NULL) {
		printf("Dosya acilamadi !!\n");
	}else{
		
		fwrite(&newbook, sizeof(struct book), 1, myptr);
		fseek(myptr, 0, SEEK_SET);
		fread(&newbook2, sizeof(struct book),1 , myptr);
	
		printf("%d - %s - %s", newbook2.bookId, newbook2.bookName, newbook2.authorName);	
		
		
		
		
	}
	fclose(myptr);
	
	
	return 0;
}
