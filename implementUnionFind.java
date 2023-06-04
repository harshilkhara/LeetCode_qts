import java.util.*;
class UnionFind{
	int[] parent;
	int[] size;

	UnionFind(int n){
		this.parent=new int[n];
		this.size=new int[n];

		for(int i=0; i<n; i++){
			parent[i]=i;
			size[i]=1;
		}
	}

	public int find(int vertex){
		if(this.parent[vertex]!=vertex){
			this.parent[vertex]=find(this.parent[vertex]);
		}
		return this.parent[vertex];
	}

	public void union(int v1, int v2){
		v1=find(v1);
		v2=find(v2);

		if(v1!=v2){
			if(this.size[v1]>this.size[v1]){
				this.parent[v2]=v1;
				size[v1]+=size[v2];
			} else {
				parent[v1]=v2;
				size[v2]+=size[v1];
			}
		}
		return;
	}
}

class implementUnionFind{
	public static void main(String[] args) {
		UnionFind uf=new UnionFind(5);
	}
}