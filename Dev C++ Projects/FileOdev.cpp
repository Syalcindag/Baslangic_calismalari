#include<stdio.h>
#include<stdlib.h>
#include <stdarg.h>

struct book {
	int bookId;
	char bookName[25];
	char authorName[25];
};
struct bookshelf {
	int row;
	int column;
	int count;
};
FILE *myptr;
FILE *myptr2;

int hashfunction(int id);
void emptyfile();
void menu1();
void menu2();



int main() {
	
	
while(true){
		printf("1. Insert a book\n");
	printf("2. Search a book\n");
	printf("3. List of the bookshelf\n");
	printf("4. Exit\n");

	int secim;
	printf("Secim yapiniz : ");
	scanf("%d", &secim);
	if(secim != 4){
		
	
	switch (secim)
	{
	case 1:
		menu1();
		break;
	case 2:
		menu2();
		break;
	case 3:
		break;
	case 4:
		break;

	}
}
    else{
     	return 0;
}
}
	system("PAUSE");
	return 0;
}

int hashfunction(int id) {
	int result;
	result = id%30;
	return result;

}
void emptyfile() {

	myptr = fopen("birincidosya.txt", "w");
	for (int i = 0; i < 150; i++) {
   			struct bookshelf empty = { 0, 0, 0 };
			fwrite(&empty, sizeof(struct bookshelf), 1, myptr);
	}
	fclose(myptr);
}
void menu1() {
	int bookId;
	char bookName[25];
	char authorName[25];

	struct book newbook;
	struct bookshelf newbookshelf;
	struct bookshelf control;

	printf("Enter the book id : ");
	scanf("%d", &bookId);
	printf("Enter the book name :");
	scanf(" %s", bookName);
	printf("Enter the author name :");
	scanf(" %s", authorName);

	        newbook.bookId = bookId;
	
			for (int i = 0; i < 25; i++) {
				newbook.bookName[i] = bookName[i];
				newbook.authorName[i] = authorName[i];
				}
	    

		
			
				
	
	if ((myptr = fopen("birincidosya.txt", "a+")) == NULL) {
		printf("Dosya acilamadi !!\n");
	}
	//Dosya acýldýysa hash fonksiyonu ile deger bulunur ve tabloda bos olan yere yerleþtirilir
	else {
		
			
	int i = 1;

	int resulthash = hashfunction(bookId);
	fseek(myptr, 5*(resulthash-1)*sizeof(struct bookshelf), SEEK_SET);
	
	
		for(int j = 0; j < 5; j++) {
				fread(&control, sizeof(struct bookshelf), 1, myptr);
				if(control.count != 0){
					fseek(myptr, sizeof(struct bookshelf), SEEK_CUR);
						i++;
				}
		}
	
	
		newbookshelf.count = bookId;
		newbookshelf.row = resulthash;
		newbookshelf.column = i;
		if (true) {
		
			fwrite(&newbookshelf, sizeof(struct bookshelf), 1, myptr);
		
		
			
			
			if((myptr2 = fopen("ikincidosya.txt","a+")) == NULL){
				printf("Ýkinci dosya açýlmadý !!");
			
	    	}else{
	    		fseek(myptr2, 5*(resulthash-1)*sizeof(struct book), SEEK_SET);
	    		for(int j = 0; j < i ; j++){
	    		fseek(myptr2, sizeof(struct book), SEEK_CUR);	
				}
			fwrite(&newbook, sizeof(struct book), 1, myptr2 );
	        	printf("Kayýt Gerceklesti\n");
			}
	      	fclose(myptr2);
		}
		else {
			printf("Boþ alan yok\n");
		}
		
		fclose(myptr);
		
	
	}//Dosya acýldýysa hash fonksiyonu ile deger bulunur ve tabloda bos olan yere yerleþtirilir

	




}
void menu2() {
	int id;
	myptr = fopen("birincidosya.txt", "r+");
//	myptr2 = fopen("ikincidosya.txt", "r+");
	printf("1. Search with Id\n");
	printf("2. Search with book name\n");
	printf("3. Search with author name\n");
	int secim;
	printf("Make Your choice : ");
	scanf("%d", &secim);
	struct bookshelf newbookshelf;
	struct book newbook;
	switch (secim)
	{
	case 1:
		printf("Id giriniz : ");
		scanf("%d", &id);
		int resultHash = hashfunction(id);
		int atlama = 0 ;
		
	
		fseek(myptr, atlama* sizeof(struct bookshelf), SEEK_SET);//bu kýsýmlardaki hatalar duzeltilecek
		
		myptr = fopen("birincidosya.txt", "r+");
		
		for(int i = 0 ; i < 5 ; i++){
			
				fread(&newbookshelf, sizeof(struct bookshelf), 1, myptr);
				if(newbookshelf.row == resultHash){
					while(newbookshelf.count != id){
						fseek(myptr, sizeof(struct bookshelf), SEEK_CUR);
						fread(&newbookshelf, sizeof(struct bookshelf), 1, myptr);
							
					}
					
					printf("%d - %d - %d ", newbookshelf.row, newbookshelf.column, newbookshelf.count);
					break;
				}
			
		}
	
	
	
	
	
		
/*			for(int j = 0; j < 1; j++) {
			
				if(newbookshelf.count == id){
					
					
				myptr2 = fopen("ikincidosya.txt", "r+");
	       	for(int i = 0; i < 150; i++){
	        	fread(&newbook, sizeof(struct book), 1, myptr2);
				if(newbook.bookId == id){
					printf(" %d - %d - %d", newbookshelf.row, newbookshelf.column, newbookshelf.count);
					printf("%d - %s - %s", newbook.bookId, newbook.bookName, newbook.authorName);
						break;
				}	}
				
				}
				
				else{
					fseek(myptr, sizeof(struct bookshelf), SEEK_SET);
				}
		}
		
		
				
	
			
		printf("\n");
		fclose(myptr);
		
	
		
		fclose(myptr2); */
		break;
	

	}
}
