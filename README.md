Проекта съдържа следните тестове за http://training.skillo-bg.com:4200/posts/all:
test case 1: RegisterProfileClass
test case 2: EditProfileTestClass
test case 3: EditProfileTestClass
test case 4: CreatePostTestClass
test case 5: CreatePostTestClass

Използван е TestBase клас и PageFactory за UI класовете.
Скрийншотите се създават както при резултат Failure така и при Success, като са обособени две отделни директории, в зависимост от резултата.
Репортите в имейл формат са конфигурирани за директория src/target/reports.

Детайли за отделните тестове:
test case 1: Register an account

1. http://training.skillo-bg.com:4200/users/login

2. Tap on "Register"

3. Fill in Register form
	3.1 username = 
	3.2 email = 
	3.3 password = 
	3.4 confrim password = 

4. Tap on Sign in button

5. Check url = http://training.skillo-bg.com:4200/posts/all

6. Tap on "Profile"

7. Check if on Profile page: http://training.skillo-bg.com:4200/users/xxxx

8. Check if username = username

--------------------------------------------------------------------------------------
test case 2: Edit email of profile

1. http://training.skillo-bg.com:4200/users/login

2. Login the app
	1.1 check http://training.skillo-bg.com:4300/users/login
	1.2 username = 
	1.3 password = 

3. Tap on Profile link

4. Check if on Profile page: http://training.skillo-bg.com:4200/users/xxxx

5. Click on Edit profile icon

6. Change email

7. Save changes

8. Open again the Edit profile modal

9. Compare email in form with edited
------------------------------------------------------------------------------------
test case 3: Change user profile picture

1. http://training.skillo-bg.com:4200/users/login

2. Login the app
	1.1 check http://training.skillo-bg.com:4200/users/login
	1.2 username = 
	1.3 password = 

3. Tap on Profile link

4. Check if Profile page is loaded

5. Upload picture for profile
----------------------------------------------------------------------

test case 4: Create public post

1. Login the app
	1.1 http://training.skillo-bg.com:4200/users/login
	1.2 username = 
	1.3 password = 

2. Check if logged in: http://training.skillo-bg.com:4200/posts/all

3. Tap on Profile

3. Check if on Profile page: http://training.skillo-bg.com:4200/users

4. Select "Public" posts filter

5. Take posts count

6. Tap on "New post"

7. Check url = http://training.skillo-bg.com:4200/posts/create

8. Upload picture

9. Enter post caption

10. Check Private/Public check box and click for public if needed

11. Save post

9. Select "Public" posts filter

10. Check if count of posts has increased wiht 1

---------------------------------------------------------------------------------

test case 5: Create a private post

1. Login the app
	1.1 http://training.skillo-bg.com:4200/users/login
	1.2 username = 
	1.3 password = 

2. Check if logged in: http://training.skillo-bg.com:4200/posts/all

3. Tap on Profile

3. Check if on Profile page: http://training.skillo-bg.com:4200/users

4. Select "Private" posts filter

5. Take posts count

6. Tap on "New post"

7. Check url = http://training.skillo-bg.com:4200/posts/create

8. Upload picture 

9. Enter post caption

10. Check Private/Public check box and click for private if needed

11. Save post

9. Select "Public" posts filter

10. Check if count of posts has increased wiht 1
