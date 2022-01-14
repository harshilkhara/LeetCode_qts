def longestCommonPrefix(strs): # TC O(S) where S is sum of each string in list// SC O(1)
    prefix=""
    if len(strs)==0: return prefix

    for i in range(len(min(strs))):
        c=strs[0][i]
        if all(a[i]==c for a in strs):
            prefix+=c
        else:
            break
    return prefix

def longestCommonPrefix1(strs): # TC O(S) // SC O(1)
    prefix=""
    if len(strs)==0:
        return prefix

    for i in range(len(strs[0])):
        for s in strs:
            if len(s)==i or s[i]!=strs[0][i]:
                return prefix
        prefix+=strs[0][i]
    return prefix

print(longestCommonPrefix(["flower","flow","flight"]))
print(longestCommonPrefix1(["flower","flow"]))