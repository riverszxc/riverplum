
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
a = TreeNode(0)
a.left = TreeNode
def test(root):
    res = []
    if not root:
        return res
    q = [root]
    while q:
        sz = len(q)
        for i in range(sz):
            t = q.pop(0)
            res.append(t.val)
            if t.left:
                q.append(t.left)
            if t.right:
                q.append(t.right)
    return res

def find(nums, target):
	if not nums:
		return -1
	l, r = 0, len(nums)-1
	while l <= r:
		mid = l + (r - l)//2
		if nums[mid] <= target:
			l = mid + 1
		else:
			r = mid - 1
	if r < 0:
		return 0
	elif nums[r] == target:
		return r
	elif l < len(nums):
		return l
	else:
		return -1