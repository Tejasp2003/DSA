               {'X', 'X', 'X', 'X'},
                        {'X', 'O', 'O', 'X'},
                        {'X', 'X', 'O', 'X'},
                        {'X', 'O', 'X', 'X'}
                        
            
                       
                    };
            
                    Solution s= new Solution();
                    s.solve(board);
                    System.out.println(Arrays.deepToString(board));