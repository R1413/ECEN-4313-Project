import random
import matplotlib
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
	
	addedge(self,node,edges):
		if self.aloc==self.edgenumber:
			return 0
		if node.aloc==node.edgenumber:
			return 0
		for i in range(self.aloc):
			if edges[i]==node:
				return 0
		if node==self:
			return 0
		
		edges[self.aloc]=node
		node.edges[node.aloc]
		edges.append([self,node])
		self.aloc+=1
		node.aloc+=1
		return 1


		
def sortnode(node,nodes):
	i=0
	dist[nodes.len]
	for n in nodes:
		dist[i]=[n,(n.location[0]-node.location[0])**2+(n.location[1]-node.location[1])**2]
		i+=1
	i=0
	out[nodes.len]
	for n in (sorted(dist,key=lambda dist: dist[1]]):
		out[i]=n[0]
		i++
	return out
	
edges=[]
thrs=0
for i in range(size):#build all nodes
	edgenumber=random.randint(3,4)
	if i==size-1:#ensure that all edges can be made
		if thrs%2:
			edgenumber=4
		else:
			edgenumber=3
	nodes[i]=node(edgenumber)
for n in nodes:
	dist[nodes.len]
	if n.edgenumber>0:
		dist=sortnode(n,nodes)
	while n.edgenumber>0:
		i=0
		while !(n.addedge(dist[i]),edges):
			i+=1

for e in edges:
	print str(e[0].getlocation())+", "+str(e[1].getlocation())
