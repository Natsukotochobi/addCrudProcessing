# MyBatis-hands-on
## 第10回課題「CRUD処理を実装」を提出
### 実装内容
#### 第9回の課題で以下を実装した。
+ "/songs"で、データベースから一覧が返ってくる。
+ "/songs/{published_year}"で、発売年が入っているカラム「year」から、該当するレコードが返ってくる。
  - 該当するレコードがなかった場合は、404エラーが返される。  
#### これに追加する形で、以下のものを新たに実装。  
+ "/create"で、songsListに新しいレコードを追加する。  
  - バリデーションエラーになった場合は、400エラーが返される。  
+ ""で、指定したidのレコードの内容を変更  
  - 指定したidのレコードが存在しなかった場合は、●●エラーが返される。  
+ ""で、指定したidのレコードを削除  
  - 指定したidのレコードが存在しなかった場合は、●●エラーが返される。

### 実行結果
##### ★一覧を取得（READ）
![image](https://user-images.githubusercontent.com/105856391/215997182-84c10ac7-ff8e-4136-8857-87e9da33c278.png)
#### ★2022年発売のものを取得（READ）
![image](https://user-images.githubusercontent.com/105856391/215997398-a11739b4-243c-490a-b4ca-a398d4cb0e14.png)
#### ★該当するレコードがない場合（READ）
![image](https://user-images.githubusercontent.com/105856391/215997809-a06590c1-8274-42b9-9bb7-4a59ed76c3b1.png)  
#### ★レコードの新規登録（CREATE）  
#### ★バリデーションエラー（CAREATE）  
#### ★レコードの内容を変更（UPDATE）  
#### ★該当するidがない場合（UPDATE）  
#### ★レコードを削除（DELETE）  
![image](image.png)
#### ★該当するidがない場合（DELETE）  

