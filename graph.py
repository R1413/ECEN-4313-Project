import random
from random import shuffle

size=50
nodes=[]

class node():
	def __init__(self,edgenumber):
		self.edgenumber=edgenumber
		self.edges=[]
		self.location=[random.randint(-1*size,size),random.randint(-1*size,size)]
		#print self.edgenumber
		
		
		self.aloc=0
		
	def getlocation(self):
		return self.location
	def setlocation(self,x,y):
		self.location=[x,y]
		return 0
	
	def addedge(self, node, e):
		if self.aloc==self.edgenumber:
			#print "self(too many edges)"
			return 0
		if node.aloc==node.edgenumber:
			#print "node(too many edges)"
			return 0
		for i in range(self.aloc):
			if self.edges[i]==node:
				#print "edge already exits"
				return 0
		if node==self:
			#print "cannot connect to self"
			return 0
		
		self.edges.append(node)
		node.edges.append(self)
		e.append([self,node])
		self.aloc+=1
		node.aloc+=1
		return 1
	
	def reset(self):
		self.edges=[]
		self.aloc=0
		self.location=[random.randint(-1*size,size),random.randint(-1*size,size)]

		return 1

		
def sortnode(node,nodes):
	i=0
	dist=[]
	for n in nodes:
		dist.append([n,(n.location[0]-node.location[0])**2+(n.location[1]-node.location[1])**2])
		i+=1
	i=0
	out=[]
	for n in (sorted(dist,key=lambda dist: dist[1])):
		out.append(n[0])
		i+=1
	return out
	
edges=[]
thrs=0
for i in range(size):#build all nodes
	#print "building nodes"
	edgenumber=random.randint(3,4)
	if i==size-1:#ensure that all edges can be made
		if thrs%2:
			edgenumber=3
		else:
			edgenumber=4
	nodes.append(node(edgenumber))
	thrs+=edgenumber
	
def connect(nodes):
	edges=[]
	shuffle(nodes)
	for n in nodes:
		#print n
		if n.edgenumber>0:
			dist=sortnode(n,nodes)
		while n.edgenumber>n.aloc:
			i=0
			while not(i>=len(nodes) or n.addedge(dist[i],edges)):
				i+=1
			if i==size:
				#print "resetting"
				for a in nodes:
					a.reset()
				return []#cannot make valid graph, start again
				print"!!!"
			#print i
	return edges
while not edges:
	edges=connect(nodes)
	
newnodes=[]
def normal(edges):
	newedges=[]
	for e in edges:
		x=e[0].getlocation()[0]
		y=e[1].getlocation()[1]
		n=node(4)
		
		n.setlocation(x,y)
		
		newnodes.append(n)
		newedges.append([e[0],n])
		newedges.append([n,e[1]])
		print newedges
	return newedges

edges=normal(edges)

for e in edges:
	print str(e[0].getlocation())+"^"+str(e[1].getlocation())
