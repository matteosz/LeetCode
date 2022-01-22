class Solution {
public:
    bool canVisitAllRooms(vector<vector<int>>& rooms) {
        int n = rooms.size();
        vector<bool> visited(n);
        unordered_set<int> keys;
        keys.insert(0);//key of room 0

        while (!keys.empty()) {
            auto x = keys.extract(keys.begin());
            int key = x.value();
            if (visited[key]) continue;
            visited[key] = true;
            for (auto k : rooms[key])
                keys.insert(k);
        }

        for (auto v : visited)
            if (!v)
                return false;
        return true;
    }
};
