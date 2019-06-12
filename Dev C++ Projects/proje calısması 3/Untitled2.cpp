
#include<stdio.h>
#include<stdlib.h>

struct bookshelf{
	int row;
	int column[5];
};
struct book{
	
};
FILE *myptr;
int main(){
	struct bookshelf newbookshelf[30];
	
	
	if((myptr = fopen("index.txt","r")) == NULL){

	//Eger Dosya Yoksa Bastan Dosya Acýyoruz Ve Ýcini Dolduruyoruz
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
	
    }
    else{
    	//Eger Dosya Varsa Dosyadan Tüm Verileri Alýyoruz
    	int i = 0;
		while(!feof(myptr)){
		fscanf(myptr, "%d %d %d %d %d %d\n", &newbookshelf[i].row, &newbookshelf[i].column[0], &newbookshelf[i].column[1], &newbookshelf[i].column[2], &newbookshelf[i].column[3], &newbookshelf[i].column[4]);	
		i++;
		}
		fclose(myptr);
		printf("okundu");
			}
    //Control Amaclý Yazýldý
   // printf("%d %d %d %d %d %d",newbookshelf[4].row, newbookshelf[4].column[0], newbookshelf[4].column[1], newbookshelf[4].column[2], newbookshelf[4].column[3], newbookshelf[4].column[4] );
	int resultHash = 9;
	int bookid = 39;
    for(int i = 0; i < 5 ; i++){
    	if(newbookshelf[resultHash].column[i] == 0){
    		newbookshelf[resultHash].column[i] = bookid;
    	//	fprintf(myptr, "%d %d %d %d %d %d\n",newbookshelf[resultHash].row, newbookshelf[resultHash].column[0], newbookshelf[resultHash].column[1], newbookshelf[resultHash].column[2], newbookshelf[resultHash].column[3], newbookshelf[resultHash].column[4] );
    myptr = fopen("index.txt", "w");
		for(int i = 0; i < 30 ; i++){
			
			fprintf(myptr, "%d %d %d %d %d %d\n",newbookshelf[i].row, newbookshelf[i].column[0], newbookshelf[i].column[1], newbookshelf[i].column[2], newbookshelf[i].column[3], newbookshelf[i].column[4]  );	
	
			}
		break;
    		
		}
	}
    	fclose(myptr);
    printf("%d %d %d %d %d %d",newbookshelf[resultHash].row, newbookshelf[resultHash].column[0], newbookshelf[resultHash].column[1], newbookshelf[resultHash].column[2], newbookshelf[resultHash].column[3], newbookshelf[resultHash].column[4] );
  system("PAUSE");
  return 0;  
    
}




