int compute_fib(int *v, int n){
    if (v[n] != -1)
        return v[n];
    if (n < 2){
        v[n] = n;
        return n;
    }
    int t = compute_fib(v,n-1) + compute_fib(v,n-2);
    v[n] = t;
    return t;
}

int fib(int n){
    int i,*fib = malloc((n+1)*sizeof(int));
    for(i=0;i<=n;i++)
        fib[i] = -1;
    return compute_fib(fib, n);
}
