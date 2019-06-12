#include<stdio.h>
#include<stdlib.h>
#include <stdarg.h>
#include<string.h>
#include<ctype.h>
struct bookshelf{
	int row;
	int column[5];
};
 struct name{
	char authorname[25];
	char bookname[25];
};
struct book{
	int row;
	struct name kayit[5];
};

FILE *myptr;
FILE *myptr2;

int hashfunction(int id);

void menu1();
void menu2();
void menu3();



int main() {
	
		while(true){

		printf("1. Insert a book\n");
	printf("2. Search a book\n");
	printf("3. List of the bookshelf\n");
	printf("4. Exit\n");

	int secim;
	printf("Lütfen 1-4 arasinda secim yapiniz : ");
	scanf("%d", &secim);
	if(!isdigit(secim)){
	

		
		//devam
	if(secim != 4 ){
	
	switch (secim)
	{
	case 1:
		menu1();
		break;
	case 2:
		menu2();
		break;
	case 3:
		menu3();
		break;
	case 4:
		break;

	}
}
else{
	break;
}
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
void menu1() {
	int bookId;
	char bookName[25];
	char authorName[25];

	struct book newbook[30];
	struct bookshelf newbookshelf[30];
	

	printf("Enter the book id : ");
	scanf("%d", &bookId);
	printf("Enter the book name :");
	scanf(" %s", bookName);
	printf("Enter the author name :");
	scanf(" %s", authorName);

	
		
	  if((myptr = fopen("index.txt","r")) == NULL){

	//Eger Dosya Yoksa Bastan Dosya Acýyoruz Ve Ýcini Dolduruyoruz
	
	//index dosyasý iþlemleri
		for(int i = 0 ; i < 30 ; i++){
			newbookshelf[i].row = i+1;
			
			for(int j = 0; j < 5; j++){
			newbookshelf[i].column[j] = 0;
					}
             }
	
		if((myptr = fopen("index.txt", "w")) == NULL){
			printf("Ýndex dosyasi acilamadi !!\n");
			}	
		else{
			for(int i = 0; i < 30 ; i++){
			
			fprintf(myptr, "%d %d %d %d %d %d\n",newbookshelf[i].row, newbookshelf[i].column[0], newbookshelf[i].column[1], newbookshelf[i].column[2], newbookshelf[i].column[3], newbookshelf[i].column[4] );	
	
			} fclose(myptr);
			}
			//index dosyasý iþlemleri sonu
			
			//book dosyasý iþlemleri
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
		}
			fclose(myptr2);
		}
	
		//book dosyasý iþlemleri sonu	
		
		}
    }
    else{
    	//Eger Dosya Varsa Dosyadan Tüm Verileri Alýyoruz
    	//index dosyasý için olan iþlemler
    	int i = 0;
		while(!feof(myptr)){
		fscanf(myptr, "%d %d %d %d %d %d\n", &newbookshelf[i].row, &newbookshelf[i].column[0], &newbookshelf[i].column[1], &newbookshelf[i].column[2], &newbookshelf[i].column[3], &newbookshelf[i].column[4]);	
		i++;
		}
		fclose(myptr);
		//index dosyasý iþlemleri sonu
	
		//book dosyasý iþlemleri
		myptr2 = fopen("book.txt","r");
		 int j = 0;
		for(j = 0 ; j < 30 ; j++){	
		fscanf(myptr2, "%d %s %s %s %s %s %s %s %s %s %s\n", &newbook[j].row,
			 newbook[j].kayit[0].bookname, newbook[j].kayit[0].authorname, 
			 newbook[j].kayit[1].bookname, newbook[j].kayit[1].authorname,
			newbook[j].kayit[2].bookname, newbook[j].kayit[2].authorname,
			newbook[j].kayit[3].bookname, newbook[j].kayit[3].authorname,
			newbook[j].kayit[4].bookname, newbook[j].kayit[4].authorname );
			
			}
			
				fclose(myptr2);
		}
	

		//book dosyasý iþlemleri sonucu
			//else sonu
	
			
		
		
		
    	int resultHash = hashfunction(bookId);//hash fonsiyonu ile resulthash adýnda raf numarsý belirledik
	
    for(int i1 = 0; i1 < 5 ; i1++){
    	if(i1 == 4 && newbookshelf[resultHash-1].column[i1] != 0){
    		printf("Ekleme Yapilamadi Bu Bolumde Bos Yer Yok");
		}
		else{
			
		int a;
    	if(newbookshelf[resultHash-1].column[i1] == 0){
    		a = i1;
    		//index dosyasý iþlemleri
    		newbookshelf[resultHash-1].column[i1] = bookId;
     myptr = fopen("index.txt", "w");
		for(int i2 = 0; i2 < 30 ; i2++){
			
			fprintf(myptr, "%d %d %d %d %d %d\n",newbookshelf[i2].row, newbookshelf[i2].column[0],
			 newbookshelf[i2].column[1], newbookshelf[i2].column[2],
			  newbookshelf[i2].column[3], newbookshelf[i2].column[4]  );	
	
			}
			//index dosyasý iþlemleri sonucu
			
			
			//book dosyasý iþlemleri
		strcpy(newbook[resultHash-1].kayit[a].authorname, authorName);	
		strcpy(newbook[resultHash-1].kayit[a].bookname, bookName);
			myptr2 = fopen("book.txt","w");
			
				for(int k = 0 ; k < 30 ; k++){
			fprintf(myptr2, "%d %s %s %s %s %s %s %s %s %s %s\n", newbook[k].row ,
			 newbook[k].kayit[0].bookname, newbook[k].kayit[0].authorname, 
			 newbook[k].kayit[1].bookname, newbook[k].kayit[1].authorname,
			newbook[k].kayit[2].bookname, newbook[k].kayit[2].authorname,
			newbook[k].kayit[3].bookname, newbook[k].kayit[3].authorname,
			newbook[k].kayit[4].bookname, newbook[k].kayit[4].authorname );
		}//for sonu
			
			//book dosyasý iþlemleri sonucu
			
		break;
    		
		}//if sonu
	}//else sonu
		}//for sonu
	
    	fclose(myptr);
    	fclose(myptr2);
    
}
void menu2() {
	
	
	


	printf("1. Search with Id\n");
	printf("2. Search with book name\n");
	printf("3. Search with author name\n");
	int secim;
	printf("Make Your choice : ");
	scanf("%d", &secim);
if(!isdigit(secim)){
	switch (secim)
	{
	case 1:
		struct bookshelf newbookshelf[30];
		struct book newbook[30];
		int bookid;
		int satirno;
		printf("Id giriniz : ");
		scanf("%d",&bookid);
		
		int resulthash ;
		resulthash= hashfunction(bookid);
		
		myptr = fopen("index.txt","r");
		myptr2 = fopen("book.txt","r");

	
	   //index dosyasý için olan iþlemler
    	int i; 
		i = 0;
		while(!feof(myptr)){
		fscanf(myptr, "%d %d %d %d %d %d\n", &newbookshelf[i].row, &newbookshelf[i].column[0], &newbookshelf[i].column[1], &newbookshelf[i].column[2], &newbookshelf[i].column[3], &newbookshelf[i].column[4]);	
		i++;
		}
		fclose(myptr);
		//index dosyasý iþlemleri sonu
		int slotsayisi ;
		
		for(int i = 0 ; i < 5 ; i++){
			if(newbookshelf[resulthash-1].column[i] == bookid){
				slotsayisi = i;
				break;
			}
		}
		//book dosyasý iþlemleri
			for(int j = 0 ; j < 30 ; j++){	
		fscanf(myptr2, "%d %s %s %s %s %s %s %s %s %s %s\n", &newbook[j].row,
			 newbook[j].kayit[0].bookname, newbook[j].kayit[0].authorname, 
			 newbook[j].kayit[1].bookname, newbook[j].kayit[1].authorname,
			newbook[j].kayit[2].bookname, newbook[j].kayit[2].authorname,
			newbook[j].kayit[3].bookname, newbook[j].kayit[3].authorname,
			newbook[j].kayit[4].bookname, newbook[j].kayit[4].authorname );
			
			}
			fclose(myptr2);
			//book dosyasý iþlemleri sonucu
	  
	  char bookname[25];
	  char authorname[25];
	  	strcpy(bookname, newbook[resulthash-1].kayit[slotsayisi].bookname);
	    strcpy(authorname, newbook[resulthash-1].kayit[slotsayisi].authorname);
	    printf("***********************************************\n");
	    printf("BookÝd : %d\nBookName : %s\n AuthorName : %s\n", bookid, bookname, authorname);
		printf("***********************************************\n");
		break;
		
	case 2:
	
		printf("BookName giriniz :");
		scanf("%s",bookname);
	
		myptr2 = fopen("book.txt","r");
		
			//book dosyasý iþlemleri
			for(int j = 0 ; j < 30 ; j++){	
		fscanf(myptr2, "%d %s %s %s %s %s %s %s %s %s %s\n", &newbook[j].row,
			 newbook[j].kayit[0].bookname, newbook[j].kayit[0].authorname, 
			 newbook[j].kayit[1].bookname, newbook[j].kayit[1].authorname,
			newbook[j].kayit[2].bookname, newbook[j].kayit[2].authorname,
			newbook[j].kayit[3].bookname, newbook[j].kayit[3].authorname,
			newbook[j].kayit[4].bookname, newbook[j].kayit[4].authorname );
			
			}
			fclose(myptr2);

			//book dosyasý iþlemleri sonucu
				int rafno;
					int slotnum ;
		for( i = 0 ; i < 30 ; i++){
			for(int k = 0 ; k < 5 ; k++){
				if(!strcmp(newbook[i].kayit[k].bookname, bookname)){
					rafno = i;
					 slotnum = k;
					 	//index dosyasý iþlemleri
			myptr = fopen("index.txt","r");	
		for(int i = 0; !feof(myptr); i++){
		fscanf(myptr, "%d %d %d %d %d %d\n", &newbookshelf[i].row, &newbookshelf[i].column[0], &newbookshelf[i].column[1], &newbookshelf[i].column[2], &newbookshelf[i].column[3], &newbookshelf[i].column[4]);	
		
		}
		fclose(myptr);
		//index dosyasý iþlemleri sonu
		
		bookid = newbookshelf[rafno].column[slotnum];
		printf("%d %s %s\n", bookid, newbook[rafno].kayit[slotnum].bookname, newbook[rafno].kayit[slotnum].authorname);
		
					 
					break;
					break;
					break;
				}
				
			}
		}
	
		break;
	case 3:
		
		printf("AuthorName Giriniz : ");
		scanf("%s", authorname);
			myptr2 = fopen("book.txt","r");
		
			//book dosyasý iþlemleri
			for(int j = 0 ; j < 30 ; j++){	
		fscanf(myptr2, "%d %s %s %s %s %s %s %s %s %s %s\n", &newbook[j].row,
			 newbook[j].kayit[0].bookname, newbook[j].kayit[0].authorname, 
			 newbook[j].kayit[1].bookname, newbook[j].kayit[1].authorname,
			newbook[j].kayit[2].bookname, newbook[j].kayit[2].authorname,
			newbook[j].kayit[3].bookname, newbook[j].kayit[3].authorname,
			newbook[j].kayit[4].bookname, newbook[j].kayit[4].authorname );
			
			}
			fclose(myptr2);
			//
				for( i = 0 ; i < 30 ; i++){
			for(int k = 0 ; k < 5 ; k++){
				if(!strcmp(newbook[i].kayit[k].authorname, authorname)){
					rafno = i;
					 slotnum = k;
					 	//index dosyasý iþlemleri
			myptr = fopen("index.txt","r");	
		for(int i = 0; !feof(myptr); i++){
		fscanf(myptr, "%d %d %d %d %d %d\n", &newbookshelf[i].row, &newbookshelf[i].column[0], &newbookshelf[i].column[1], &newbookshelf[i].column[2], &newbookshelf[i].column[3], &newbookshelf[i].column[4]);	
		
		}
		fclose(myptr);
		//index dosyasý iþlemleri sonu
		
		bookid = newbookshelf[rafno].column[slotnum];
		printf("%d %s %s\n", bookid, newbook[rafno].kayit[slotnum].bookname, newbook[rafno].kayit[slotnum].authorname);
		
					 
					break;
					break;
					break;
				
				}
				
			}
		}

		break;
		
		
	
	
	}
}

	
}
void menu3(){
	
	    struct bookshelf newbookshelf[30];
		struct book newbook[30];
		
			myptr2 = fopen("book.txt","r");
		
			//book dosyasý iþlemleri
			for(int j = 0 ; j < 30 ; j++){	
		fscanf(myptr2, "%d %s %s %s %s %s %s %s %s %s %s\n", &newbook[j].row,
			 newbook[j].kayit[0].bookname, newbook[j].kayit[0].authorname, 
			 newbook[j].kayit[1].bookname, newbook[j].kayit[1].authorname,
			newbook[j].kayit[2].bookname, newbook[j].kayit[2].authorname,
			newbook[j].kayit[3].bookname, newbook[j].kayit[3].authorname,
			newbook[j].kayit[4].bookname, newbook[j].kayit[4].authorname );
			
			}
			fclose(myptr2);
	printf("*************************************************************\n");		
	printf("Shelf Number   B1  \t  B2  \t  B3  \t     B4  \t     B5 \n");
	for(int j = 0 ; j < 30 ; j++){
	
	printf("%d 	      %s       %s       %s        %s       %s \n", newbook[j].row,
	 newbook[j].kayit[0].bookname, newbook[j].kayit[1].bookname,
	newbook[j].kayit[2].bookname, newbook[j].kayit[3].bookname,
	newbook[j].kayit[4].bookname );
    }
	printf("*************************************************************\n");	
}

