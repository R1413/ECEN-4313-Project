import random
size=20
nodes[size]

class node():
	def __init__(self,edgenumber):
		self.location=[random.randint(-1*size,size),random.randint(-1*size,size)]
		self.edgenumber=edgenumber
		self.edges[edgenumber]
		for i in range(self.edgenumber):
			self.edges[i]=-1
		self.aloc=0
		
	getlocation(self):
		return self.location
	
	addedge(self,node):
		if self.aloc==self.edgenumber-1:
			return 0
		for i in range(self.aloc):
			if edges[i]==node:
				return 0
		
		edges[self.aloc]=node
		return 1
			
thrs=0
for i in range(size):#build all nodes
	edgenumber=random.randint(3,4)
	if i==size-1:#ensure that all edges can be made
		if thrs%2:
			edgenumber=4
		else:
			edgenumber=3
	nodes[i]=node(edgenumber)

