#include<stdio.h>
#include<stdlib.h>
#include <stdarg.h>
#include<conio.h>
#include<string.h>

struct book {
	int bookId;
	char bookName[25];
	char authorName[25];
};
struct bookshelf {
	int row;
	int column[5];
	
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
	int rafnum ;
	int dizi[30][6];
	myptr = fopen("index.txt", "w");
	for (int i = 0; i < 30; i++) {
		rafnum = i;
   		fprintf(myptr, "%d%d%d%d%d%d\n", rafnum, 0, 0, 0, 0, 0);
	}
	fclose(myptr);
}
void menu1() {
	int bookId;
	char bookName[25];
	char authorName[25];

//	struct book newbook;
	struct bookshelf newbookshelf[30];
	struct bookshelf control;

	printf("Enter the book id : ");
	scanf("%d", &bookId);
	printf("Enter the book name :");
	scanf(" %s", bookName);
	printf("Enter the author name :");
	scanf(" %s", authorName);

		struct bookshelf newbook[30];
		
		for(int i = 0 ; i < 30 ; i++){
			newbookshelf[i].row = i+1;
			
			for(int j = 0; j < 5; j++){
			newbookshelf[i].column[j] = 0;
				
			}
		
			
		}
		if((myptr = fopen("index.txt", "r")) == NULL){
			
			
			if((myptr = fopen("index.txt", "w")) == NULL){
			printf("Ýndex dosyasi acilamadi !!\n");
			}	
			else{
			for(int i = 0; i < 30 ; i++){
			
			fprintf(myptr, "%d %d %d %d %d %d\n",newbookshelf[i].row, newbookshelf[i].column[0], newbookshelf[i].column[1], newbookshelf[i].column[2], newbookshelf[i].column[3], newbookshelf[i].column[4]  );	
	
			}	
			}
		
			
		}
		else{
			
			
				for(int i = 0; i < 30 ; i++){
		fscanf(myptr, "%d %d %d %d %d %d",newbookshelf[i].row, newbookshelf[i].column[0], newbookshelf[i].column[1], newbookshelf[i].column[2], newbookshelf[i].column[3], newbookshelf[i].column[4]  );	
		}
		}
		fclose(myptr);
		
		
		int j = 0;
		
				
		//BookÝd ye hash fonksiyonu uyguluyoruz
		int resultHash = hashfunction(bookId);		
				
	    
	/*	//Ýndex Dosyasýný Acma
		if((myptr = fopen("index.txt", "w")) == NULL){
			printf("Ýndex dosyasi acilamadi !!");
		}
		//Kitap Dosyasýný Acma
		if((myptr2 = fopen("kitap.txt","a+")) == NULL){
			printf("Kitap dosyasý acilamadi !!");
		}
		else{
			for(int i = 0 ; i < 30 ; i++){
				if(resultHash == i){
					for(int j = 0; j < 5 ; j++){
						if(newbookshelf[i].column[j] == 0){
							newbookshelf[i].column[j] = bookId;
								for(int i = 0; i < 30 ; i++){
		fprintf(myptr, "%d %d %d %d %d %d\n",newbookshelf[i].row, newbookshelf[i].column[0], newbookshelf[i].column[1], newbookshelf[i].column[2], newbookshelf[i].column[3], newbookshelf[i].column[4]  );	
		}
						return;
						}
						
					}
					
				}
			}	*/
			
			fclose(myptr);
		//	fclose(myptr2);
			
	//	}
		
	

	




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
	/*	printf("Id giriniz : ");
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
	
*/
		break;
	

	}
}
