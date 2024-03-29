# MyBatis-hands-on
## 第10回課題「CRUD処理を実装」を提出
### 実装内容
#### 第9回の課題で以下を実装した。
+ "/song"で、データベースから一覧が返ってくる。
+ "/song/search?year=○○"で、発売年が入っているカラム「year」から、該当するレコードが返ってくる。
  - 該当するレコードがなかった場合は、404エラーが返される。  
#### これに追加する形で、以下のものを新たに実装。  
+ "/create"で、songsListに新しいレコードを追加する。  
  - バリデーションエラーになった場合は、400エラーが返される。  
+ "/update/{id}"で、指定したidのレコードの内容を変更  
  - 指定したidのレコードが存在しなかった場合は、404エラーが返される。  
+ "/delete/{id}"で、指定したidのレコードを削除  
  - 指定したidのレコードが存在しなかった場合は、404エラーが返される。

### 実行結果
##### ★一覧を取得（/song）
![image](https://user-images.githubusercontent.com/105856391/215997182-84c10ac7-ff8e-4136-8857-87e9da33c278.png)
#### ★2023年発売のものを取得（/search?year=2023）
![](imgs/2023-04-24-10-22-51.png)
#### ★該当するレコードがない場合（/search?year=202333）
![](imgs/2023-04-24-10-23-55.png)
#### ★レコードの新規登録（/create）  
![](imgs/2023-04-20-10-00-10.png)  
![](imgs/2023-04-20-10-01-40.png)
#### ★バリデーションエラー（/create）  
![](imgs/2023-04-20-10-07-22.png)  
#### ★レコードの内容を変更（/update/22）  
![](imgs/2023-04-20-10-10-30.png)  
![](imgs/2023-04-20-10-12-15.png)  
![](imgs/2023-04-20-10-12-50.png)  
#### ★該当するidがない場合（/update/123456）  
![](imgs/2023-04-20-10-37-43.png)
#### ★レコードを削除（/delete/1）  
![](imgs/2023-04-20-10-32-28.png)  
![](imgs/2023-04-20-10-34-56.png)
#### ★該当するidがない場合（/delete/123456）
![](imgs/2023-04-20-10-35-53.png)  

