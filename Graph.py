import matplotlib.pyplot as plt
import pandas as pd
import numpy as np


# url = 'https://archive.ics.uci.edu/ml/machine-learning-databases/wine/wine.data'
# cols =  ['Class', 'Alcohol', 'MalicAcid', 'Ash', 'AlcalinityOfAsh', 'Magnesium', 'TotalPhenols', 
#          'Flavanoids', 'NonflavanoidPhenols', 'Proanthocyanins', 'ColorIntensity', 
#          'Hue', 'OD280/OD315', 'Proline']
# data = pd.read_csv(url, names=cols)
# print(data)
# y = data['Class']          # Split off classifications

# X = data.drop(columns=['Class']) # Split off features


# plt.scatter(X[y==1]['Alcohol'], X[y==1]['MalicAcid'], label='Class 1', c='red')
# plt.scatter(X[y==2]['Alcohol'], X[y==2]['MalicAcid'], label='Class 2', c='blue')
# plt.scatter(X[y==3]['Alcohol'], X[y==3]['MalicAcid'], label='Class 3', c='lightgreen')

# # # Prettify the graph
# plt.legend()
# plt.xlabel('Flavanoids')
# plt.ylabel('NonflavanoidPhenols')

# # display
# plt.show()

url = 'model.csv'
cols =  ['id','a','b','c','d','e','f','g','Class']
data = pd.read_csv(url, names=cols)
print(data)
y = data['Class']          # Split off classifications
# arr = []
X = data.drop(columns=['Class']) # Split off features
# index = 0
# for i in range(1,2001):

#     arr.insert(index,i)
#     index = index+1


plt.scatter(X[y==0]['id'], X[y==0]['a'], label='Cluster 0', c='#30336b')
plt.scatter(X[y==1]['id'], X[y==1]['a'], label='Cluster 1', c='red')
plt.scatter(X[y==2]['id'], X[y==2]['a'], label='Cluster 2', c='green')
plt.scatter(X[y==3]['id'], X[y==3]['a'], label='Cluster 3', c='cyan')

# plt.scatter(X[y==0]['id'], X[y==0]['b'], c='#30336b')
# plt.scatter(X[y==1]['id'], X[y==1]['b'], c='red')
# plt.scatter(X[y==2]['id'], X[y==2]['b'], c='green')
# plt.scatter(X[y==3]['id'], X[y==3]['b'], c='cyan')



# plt.scatter(X[y==0]['a'], X[y==0]['b'], c='#30336b')
# plt.scatter(X[y==1]['a'], X[y==1]['b'] , c='red')
# plt.scatter(X[y==2]['a'], X[y==2]['b'] , c='green')
# plt.scatter(X[y==3]['a'], X[y==3]['b'], c='cyan')

# plt.scatter(X[y==0]['a'], X[y==0]['c'], c='#30336b')
# plt.scatter(X[y==1]['a'], X[y==1]['c'], c='red')
# plt.scatter(X[y==2]['a'], X[y==2]['c'], c='green')
# plt.scatter(X[y==3]['a'], X[y==3]['c'], c='cyan')

# plt.scatter(X[y==0]['a'], X[y==0]['d'], c='#30336b')
# plt.scatter(X[y==1]['a'], X[y==1]['d'], c='red')
# plt.scatter(X[y==2]['a'], X[y==2]['d'], c='green')
# plt.scatter(X[y==3]['a'], X[y==3]['d'], c='cyan')

# plt.scatter(X[y==0]['a'], X[y==0]['e'], c='#30336b')
# plt.scatter(X[y==1]['a'], X[y==1]['e'], c='red')
# plt.scatter(X[y==2]['a'], X[y==2]['e'], c='green')
# plt.scatter(X[y==3]['a'], X[y==3]['e'], c='cyan')

# plt.scatter(X[y==0]['a'], X[y==0]['f'], c='#30336b')
# plt.scatter(X[y==1]['a'], X[y==1]['f'], c='red')
# plt.scatter(X[y==2]['a'], X[y==2]['f'], c='green')
# plt.scatter(X[y==3]['a'], X[y==3]['f'], c='cyan')

# plt.scatter(X[y==0]['a'], X[y==0]['g'], c='#30336b')
# plt.scatter(X[y==1]['a'], X[y==1]['g'], c='red')
# plt.scatter(X[y==2]['a'], X[y==2]['g'], c='green')
# plt.scatter(X[y==3]['a'], X[y==3]['g'], c='cyan')



    
    

# # Prettify the graph
plt.legend()
plt.xlabel('nguồn phát 1')
plt.ylabel('nguồn phát 2')

# display
plt.show()