import os

db_user = os.environ.get('DB_USER')
db_password = os.environ.get('DB_PASS')

print(db_user)
print(db_password)


'''
In terminal- 

sudo nano  ~/.zshrc

export DB_USER="Enter your email id here"
export DB_PASS="Enter your password here"

'''
