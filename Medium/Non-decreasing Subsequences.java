class Solution {
public:
    void dfs(vector<int>& nums, vector<vector<int>>& ans, vector<int>& sub, int idx) {
      if (sub.size() >= 2) ans.push_back(sub);
      if (idx == nums.size()) return;

      bool chk[205] = {};
      for (int i = idx; i < nums.size(); i++) {
        if (!sub.size() || sub.back() <= nums[i]) {
          if (chk[nums[i] + 100]) continue;
          chk[nums[i]+100] = true;
          sub.push_back(nums[i]);
          dfs(nums,ans,sub,i+1);
          sub.pop_back();
        }
      }
    }
    vector<vector<int>> findSubsequences(vector<int>& nums) {
      vector<vector<int>> ans;
      vector<int> sub;
      dfs(nums, ans, sub, 0);
      return ans;
    }
};
