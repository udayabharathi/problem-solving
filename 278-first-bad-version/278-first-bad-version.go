/** 
 * Forward declaration of isBadVersion API.
 * @param   version   your guess about first bad version
 * @return 	 	      true if current version is bad 
 *			          false if current version is good
 * func isBadVersion(version int) bool;
 */

func firstBadVersion(n int) int {
    l := 1
    h := n
    for l <= h {
        mid := (l - h) / 2 + h
        if isBadVersion(mid) {
            h = mid - 1
        } else {
            l = mid + 1
        }
    }
    return l
}